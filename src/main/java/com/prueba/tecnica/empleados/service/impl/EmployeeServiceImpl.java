package com.prueba.tecnica.empleados.service.impl;

import com.prueba.tecnica.empleados.dto.EmployeeDTO;
import com.prueba.tecnica.empleados.persistent.repository.DepartmentRepository;
import com.prueba.tecnica.empleados.persistent.repository.EmployeeRepository;
import com.prueba.tecnica.empleados.persistent.repository.TitleRepository;
import com.prueba.tecnica.empleados.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final DepartmentRepository departmentRepository;

    private final TitleRepository titleRepository;

    @Override
    public List<EmployeeDTO> findByIdDepartment(Long id) {

        log.info("Ejecutando metodo findByIdDepartment - department ID: {}", id);

        // verificacion existencia departamento
        if (!departmentRepository.existsById(id)) {
            log.warn("Department no encontrado");
            throw new NoSuchElementException("No se encuentra el departamento");
        }

        return employeeRepository.findByIdDepartment(id);
    }

    @Override
    public List<EmployeeDTO> findByNameChargeAndIdEmployeeManager(String name, Long employeeManagerId) {

        log.info("Ejecutando metodo findByNameChargeAndIdEmployeeManager " +
                "- cargo: {}, employe manager ID: {}", name, employeeManagerId);

        if (!titleRepository.existsByTitleIgnoreCase(name)) {
            log.warn("cargo no encontrado");
            throw new NoSuchElementException("No se encuentra el cargo");
        }

        if (!employeeRepository.existsById(employeeManagerId)) {
            log.warn("empleado no encontrado");
            throw new NoSuchElementException("No se encuentra el empleado");
        }

        return employeeRepository.findByNameChargeAndIdEmployeeManager(name, employeeManagerId);
    }
}
