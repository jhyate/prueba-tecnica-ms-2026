package com.prueba.tecnica.empleados.api;

import com.prueba.tecnica.empleados.dto.EmployeeDTO;
import com.prueba.tecnica.empleados.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findByNameChargeAndIdEmployeeManager(
            @RequestParam(name = "nameCharge", required = true) String nameCharge,
            @RequestParam(name = "idManager", required = true) Long idManager) {

        log.info("Ejecutando API Employee - servicio findByNameChargeAndIdEmployeeManager" +
                " name: {}, ID jefe: {}", nameCharge, idManager);

        try {
            return  ResponseEntity.ok(employeeService.findByNameChargeAndIdEmployeeManager(nameCharge, idManager));
        } catch (NoSuchElementException e) {
            return ResponseEntity.noContent().build();
        }

    }

}
