package com.prueba.tecnica.empleados.persistent.entity;

import com.prueba.tecnica.empleados.utils.SexEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_EMPLOYEES")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BIRTH_DATE")
    private LocalDateTime birthDate;

    @Column(name = "FIRST_NAME", nullable = false, length = 14)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 16)
    private String lastName;

    @Column(name = "SEX")
    private String sex;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "HIRE_DATE")
    private LocalDateTime hireDate;
}
