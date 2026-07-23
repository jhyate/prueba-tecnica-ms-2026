package com.prueba.tecnica.empleados.api;

import com.prueba.tecnica.empleados.dto.EmployeeDTO;
import com.prueba.tecnica.empleados.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("${spring.api.employee.main-url}")
public class EmployeeApi {

    private final EmployeeService employeeService;

    @GetMapping(value = "/{departmentId}")
    public ResponseEntity<List<EmployeeDTO>> findByIdDepartment(
            @PathVariable(name = "departmentId", required = true) Long departmentId) {
        log.info("Ejecutando API Employee - servicio findByIdDepartment ID: {}", departmentId);

        try {
            return  ResponseEntity.ok(employeeService.findByIdDepartment(departmentId));
        } catch (NoSuchElementException e) {
            return ResponseEntity.noContent().build();
        }

    }

}
