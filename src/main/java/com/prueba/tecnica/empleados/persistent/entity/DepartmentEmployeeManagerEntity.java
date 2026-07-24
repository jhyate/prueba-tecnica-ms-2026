package com.prueba.tecnica.empleados.persistent.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_DEPT_MANAGER")
public class DepartmentEmployeeManagerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;

    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    @Column(name = "FROM_DATE")
    private LocalDateTime fromDate;

    @Column(name = "TO_DATES")
    private LocalDateTime toDate;
}
