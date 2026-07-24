package com.prueba.tecnica.empleados.api;

import com.prueba.tecnica.empleados.dto.DepartmentRequestDTO;
import com.prueba.tecnica.empleados.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("${spring.api.department.main-url}")
public class DepartmentApi {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Long> create(
            @Valid @RequestBody DepartmentRequestDTO request) {

        log.info("Ejecutando API Department - servicio create REQUEST: {}", request);

        try {
            return  ResponseEntity.ok(departmentService.create(request));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }
}
