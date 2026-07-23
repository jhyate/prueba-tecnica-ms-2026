package com.prueba.tecnica.empleados.service;

import com.prueba.tecnica.empleados.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> findByIdDepartment(Long id);

    List<EmployeeDTO> findByNameChargeAndIdEmployeeManager(String name, Long employeeManagerId);
}
