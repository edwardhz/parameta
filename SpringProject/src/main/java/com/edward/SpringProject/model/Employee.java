package com.edward.SpringProject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "El campo 'nombres' es obligatorio.")
    private String nombres;
    @NotEmpty(message = "El campo 'apellidos' es obligatorio.")
    private String apellidos;

    @NotEmpty(message = "El campo 'tipoDocumento' es obligatorio.")
    private String tipoDocumento;

    @NotEmpty(message = "El campo 'numeroDocumento' es obligatorio.")
    private String numeroDocumento;

    @NotNull(message = "El campo 'birthDate' es obligatorio.")
    private LocalDate birthDate;

    @NotNull(message = "El campo 'joinDate' es obligatorio.")
    private LocalDate joinDate;

    @NotEmpty(message = "El campo 'cargo' es obligatorio.")
    private String cargo;

    @NotNull(message = "El campo 'salario' es obligatorio.")
    private Double salario;

    // Atributos calculados para la respuesta
    @Transient
    private String age;
    @Transient
    private String tenure;

    // Getters y setters


    public Employee() {

    }

    // Constructor
    public Employee(int id,String nombres, String apellidos, String tipoDocumento, String numeroDocumento,
                    LocalDate birthDate, LocalDate joinDate, String cargo, Double salario) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.birthDate = birthDate;
        this.joinDate = joinDate;
        this.cargo = cargo;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }
}
