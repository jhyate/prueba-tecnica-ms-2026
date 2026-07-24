package com.prueba.tecnica.empleados.service.impl;

import com.prueba.tecnica.empleados.dto.DepartmentRequestDTO;
import com.prueba.tecnica.empleados.persistent.entity.DepartmentEntity;
import com.prueba.tecnica.empleados.persistent.repository.DepartmentEmployeeManagerRepository;
import com.prueba.tecnica.empleados.persistent.repository.DepartmentRepository;
import com.prueba.tecnica.empleados.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentEmployeeManagerRepository departmentEmployeeManagerRepository;

    private final DepartmentRepository departmentRepository;

    @Override
    public Long create(DepartmentRequestDTO request) {

        log.info("Ejecutando metodo createDepartment - REQUEST: {}", request);

        if (!departmentEmployeeManagerRepository.existsByEmployeeId(request.getIdEmployeeManager())) {
            log.warn("Jefe del departamento no encontrado");
            throw new NoSuchElementException("No se encuentra el jefe del departamento");
        }

        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setDepartmentName(request.getName());

        DepartmentEntity response = departmentRepository.save(departmentEntity);

        return response.getId();
    }
}
