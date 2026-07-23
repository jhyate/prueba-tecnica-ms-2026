package com.prueba.tecnica.empleados.persistent.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_DEPARTMENTS")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DEPT_NAME")
    private String departmentName;
}
