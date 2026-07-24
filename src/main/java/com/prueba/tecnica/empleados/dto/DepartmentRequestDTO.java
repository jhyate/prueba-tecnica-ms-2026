package com.prueba.tecnica.empleados.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DepartmentRequestDTO {

    @NotNull(message = "El name es obligatorio")
    private String name;
    @NotNull(message = "El idEmployeeManager es obligatorio")
    private Long idEmployeeManager;
    private Long idLocation;
}
