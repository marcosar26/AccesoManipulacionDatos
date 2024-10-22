package com.dwes.AccesoManipulacionDatos.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.List;

@Value
public class LibrosDto implements Serializable {
    List<LibroDto> libros;
    int numPaginasTotales;
    int cantidadTotal;
}
