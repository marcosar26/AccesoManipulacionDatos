package com.dwes.AccesoManipulacionDatos.controller;

import com.dwes.AccesoManipulacionDatos.dto.EmpleadoDto;
import com.dwes.AccesoManipulacionDatos.dto.HistoricoEmpleadoRequestDTO;
import com.dwes.AccesoManipulacionDatos.model.Empleado;
import com.dwes.AccesoManipulacionDatos.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDto>> getAll() {
        List<EmpleadoDto> empleados = empleadoService.findAll();
        return empleados.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(empleados);
    }

    @PutMapping("/add")
    public ResponseEntity<EmpleadoDto> addEmpleado(@RequestBody Empleado empleado) {
        EmpleadoDto emp = empleadoService.addEmpleado(empleado);
        return emp == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(emp);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<EmpleadoDto> eliminarEmpleado(@RequestParam Long id) {
        EmpleadoDto emp = empleadoService.eliminarEmpleado(id);
        return emp == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(emp);
    }

    @GetMapping("/getHistoricoEmpleados")
    public ResponseEntity<HistoricoEmpleadoRequestDTO> getHistoricoEmpleadoRequestDTO() {
        HistoricoEmpleadoRequestDTO obj = empleadoService.getHistoricoEmpleadoRequestDTO();
        return obj == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(obj);
    }
}
