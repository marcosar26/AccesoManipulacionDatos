package com.dwes.AccesoManipulacionDatos.controller;

import com.dwes.AccesoManipulacionDatos.dto.SeccionDto;
import com.dwes.AccesoManipulacionDatos.model.Empleado;
import com.dwes.AccesoManipulacionDatos.model.Seccion;
import com.dwes.AccesoManipulacionDatos.service.SeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secciones")
public class SeccionController {
    private final SeccionService seccionService;

    @Autowired
    public SeccionController(SeccionService seccionService) {
        this.seccionService = seccionService;
    }

    @GetMapping
    public ResponseEntity<List<SeccionDto>> getAll() {
        List<SeccionDto> secciones = seccionService.findAll();
        return secciones.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(secciones);
    }

    @PutMapping("/add")
    public ResponseEntity<SeccionDto> addSeccion(@RequestBody Seccion seccion) {
        SeccionDto sec = seccionService.addSeccion(seccion);
        return sec == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(sec);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<SeccionDto> eliminarSeccion(@RequestParam Long id) {
        SeccionDto sec = seccionService.eliminarSeccion(id);
        return sec == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(sec);
    }

    @GetMapping("/buscarEmpleados")
    public ResponseEntity<List<Empleado>> buscarEmpleadosPorSeccion(@RequestParam Long id) {
        List<Empleado> empleados = seccionService.buscarEmpleadosPorSeccion(id);
        return empleados.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(empleados);
    }
}
