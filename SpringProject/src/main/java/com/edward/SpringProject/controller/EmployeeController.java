package com.edward.SpringProject.controller;

import com.edward.SpringProject.model.Employee;
import com.edward.SpringProject.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @GetMapping("/create")  // Cambiado a PostMapping
//    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
//        // Guardar y devolver el empleado creado
//        Employee savedEmployee = employeeService.saveEmployee(employee);
//        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
//    }
@GetMapping("/create")
public ResponseEntity<?> createEmployee(
        @RequestParam(required = true) String nombres,
        @RequestParam(required = true) String apellidos,
        @RequestParam(required = true) String tipoDocumento,
        @RequestParam(required = true) String numeroDocumento,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate joinDate,
        @RequestParam(required = true) String cargo,
        @RequestParam(required = false) Double salario) {

    Map<String, String> fields = Map.of(
            "nombres", nombres,
            "apellidos", apellidos,
            "tipoDocumento", tipoDocumento,
            "numeroDocumento", numeroDocumento,
            "cargo", cargo
    );

    // Verificar si hay campos vacíos
    for (Map.Entry<String, String> field : fields.entrySet()) {
        if (field.getValue().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Error-Code", "4001")
                    .body("El campo '" + field.getKey() + "' es obligatorio.");
        }
    }
    // Verificar salario
    if (salario == null) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .header("Error-Code", "4001")
                .body("El campo 'salario' es obligatorio.");
    }

    // Verificar que el salario sea positivo
    if (salario <= 0) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .header("Error-Code", "4003")
                .body("El salario debe ser un valor positivo.");
    }


    // Validar que el empleado sea mayor de edad
    LocalDate today = LocalDate.now();
    if (Period.between(birthDate, today).getYears() < 18) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .header("Error-Code", "4002")
                .body("El empleado debe ser mayor de edad.");
    }
    // Crear el objeto Employee
    Employee employee = new Employee(0, nombres, apellidos, tipoDocumento, numeroDocumento, birthDate, joinDate, cargo, salario);

    // Guardar y devolver el empleado creado
    Employee savedEmployee = employeeService.saveEmployee(employee);
    Employee updatedEmployee = employeeService.prepareEmployeeResponse(savedEmployee);
    return new ResponseEntity<>(updatedEmployee, HttpStatus.CREATED);
}

}


