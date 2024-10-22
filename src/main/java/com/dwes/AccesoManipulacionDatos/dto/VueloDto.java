package com.dwes.AccesoManipulacionDatos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.dwes.AccesoManipulacionDatos.model.Vuelo}
 */
@Value
public class VueloDto implements Serializable {
    @NotBlank
    String origen;
    @NotBlank
    String destino;
    LocalDateTime fecha_salida;
    LocalDateTime fecha_llegada;
}