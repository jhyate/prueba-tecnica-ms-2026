package com.prueba.tecnica.empleados.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DepartmentRequestDTO {

    @Schema(description = "Nombre del departamento", example = "Tecnologia")
    @NotNull(message = "El name es obligatorio")
    private String name;

    @Schema(description = "ID del jefe", example = "1")
    @NotNull(message = "El idEmployeeManager es obligatorio")
    private Long idEmployeeManager;
    private Long idLocation;
}
