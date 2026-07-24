package com.prueba.tecnica.empleados.persistent.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TBL_DEPARTMENTS")
@Data
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DEPT_NAME")
    private String departmentName;
}
