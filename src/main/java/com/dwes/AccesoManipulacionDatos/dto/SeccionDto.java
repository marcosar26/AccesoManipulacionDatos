package com.dwes.AccesoManipulacionDatos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.dwes.AccesoManipulacionDatos.model.Seccion}
 */
@Value
public class SeccionDto implements Serializable {
    @NotBlank
    String nombre;
}