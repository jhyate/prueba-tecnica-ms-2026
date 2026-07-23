package com.prueba.tecnica.empleados.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDTO {

    private Long id;
    private String name;
    private String lastname;
    private String email;
    private LocalDateTime hireDate;
    private String nameCharge;
    private Integer salary;
    private Integer commission;
    private String nameDepartment;
    private String nameManager;


    public EmployeeDTO(Long id, String name, LocalDateTime hireDate, String nameCharge, Integer salary, String nameDepartment) {
        this.id = id;
        this.name = name;
        this.hireDate = hireDate;
        this.nameCharge = nameCharge;
        this.salary = salary;
        this.nameDepartment = nameDepartment;
    }

    public EmployeeDTO(String name, String lastname,  String email, String nameCharge, Integer salary, Integer commission, String nameManager) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.nameCharge = nameCharge;
        this.salary = salary;
        this.commission = commission;
        this.nameManager = nameManager;
    }
}
