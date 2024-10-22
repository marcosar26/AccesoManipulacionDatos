package com.dwes.AccesoManipulacionDatos.controller;

import com.dwes.AccesoManipulacionDatos.dto.VueloDto1;
import com.dwes.AccesoManipulacionDatos.model.Vuelo;
import com.dwes.AccesoManipulacionDatos.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class VueloController {
    private final VueloService vueloService;

    @Autowired
    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping
    public ResponseEntity<List<VueloDto1>> findAll() {
        List<VueloDto1> vuelos = vueloService.findAll();
        return vuelos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(vuelos);
    }

    @PutMapping("/add")
    public ResponseEntity<VueloDto1> addVuelo(@RequestBody Vuelo vuelo) {
        VueloDto1 vueloDto = vueloService.save(vuelo);
        return vueloDto == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(vueloDto);
    }

    @PatchMapping("/editar/{id}")
    public ResponseEntity<VueloDto1> actualizarVuelo(@PathVariable Long id, @RequestBody Vuelo vuelo) {
        VueloDto1 vueloDto = vueloService.actualizarVuelo(id, vuelo);
        return vueloDto == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(vueloDto);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<VueloDto1> eliminarVuelo(@PathVariable Long id) {
        VueloDto1 vueloDto = vueloService.eliminarVuelo(id);
        return vueloDto == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(vueloDto);
    }
}
