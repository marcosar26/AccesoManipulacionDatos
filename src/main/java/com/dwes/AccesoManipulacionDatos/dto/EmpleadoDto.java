package com.dwes.AccesoManipulacionDatos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.dwes.AccesoManipulacionDatos.model.Empleado}
 */
@Value
public class EmpleadoDto implements Serializable {
    @NotBlank
    String nombre;
    String apellido;
    @Email
    String correo_electronico;
}