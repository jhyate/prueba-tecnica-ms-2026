package com.prueba.tecnica.empleados.persistent.repository;

import com.prueba.tecnica.empleados.persistent.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
