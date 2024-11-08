package com.dwes.AccesoManipulacionDatos.controller;

import com.dwes.AccesoManipulacionDatos.model.Empleado;
import com.dwes.AccesoManipulacionDatos.service.EmpleadoSeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleados_secciones")
public class EmpleadoSeccionController {
    private final EmpleadoSeccionService empleadoSeccionService;

    @Autowired
    public EmpleadoSeccionController(EmpleadoSeccionService empleadoSeccionService) {
        this.empleadoSeccionService = empleadoSeccionService;
    }

    @PostMapping("/asignar")
    public ResponseEntity<Empleado> asignarEmpleado(@RequestParam Long empleadoId, @RequestParam Long seccionId) {
        return ResponseEntity.ok(empleadoSeccionService.asignarSeccion(empleadoId, seccionId));
    }

    @PostMapping("/cambiarSeccionEmpleado")
    public ResponseEntity<Empleado> cambiarSeccionEmpleado(@RequestParam Long empleadoId, @RequestParam Long seccionId) {
        return ResponseEntity.ok(empleadoSeccionService.cambiarSeccionEmpleado(empleadoId, seccionId));
    }

    @DeleteMapping("/eliminarEmpleadoDeSeccion")
    public ResponseEntity<Empleado> eliminarEmpleadoDeSeccion(@RequestParam Long empleadoId, @RequestParam Long seccionId) {
        return ResponseEntity.ok(empleadoSeccionService.eliminarSeccionEmpleado(empleadoId, seccionId));
    }
}
