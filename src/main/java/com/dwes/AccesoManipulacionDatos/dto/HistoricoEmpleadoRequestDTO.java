package com.dwes.AccesoManipulacionDatos.dto;

import lombok.Value;

import java.util.List;

@Value
public class HistoricoEmpleadoRequestDTO {
    double salario_medio;
    double salario_maximo;
    double salario_minimo;
    List<EmpleadoDto> empleados;
}
