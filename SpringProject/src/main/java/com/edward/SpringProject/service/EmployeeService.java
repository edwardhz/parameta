package com.edward.SpringProject.service;

import com.edward.SpringProject.model.Employee;
import com.edward.SpringProject.repository.EmployeeRepository;
import com.edward.SpringProject.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee prepareEmployeeResponse(Employee employee) {
        // Cálculo de la edad actual y el tiempo de vinculación
        employee.setAge(DateUtils.calculateDurationFromNow(employee.getBirthDate()));
        employee.setTenure(DateUtils.calculateDurationFromNow(employee.getJoinDate()));
        return employee;
    }

}
