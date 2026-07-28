package com.prueba.tecnica.empleados.persistent.repository;

import com.prueba.tecnica.empleados.persistent.entity.DepartmentEmployeeManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentEmployeeManagerRepository extends JpaRepository<DepartmentEmployeeManagerEntity, Long> {

    boolean existsByEmployeeId(Long id);

}
