package com.dwes.AccesoManipulacionDatos.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.dwes.AccesoManipulacionDatos.model.Vuelo}
 */
@Value
public class VueloDto1 implements Serializable {
    Long id;
    @Positive
    int capacidad_asientos;
    @PositiveOrZero
    double precio;
    double total;
}