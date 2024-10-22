package com.dwes.AccesoManipulacionDatos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.dwes.AccesoManipulacionDatos.model.Libro}
 */
@Value
public class LibroDto implements Serializable {
    @NotBlank
    String titulo;
    @NotBlank
    String autor;
}