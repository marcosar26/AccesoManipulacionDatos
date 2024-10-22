package com.dwes.AccesoManipulacionDatos.controller;

import com.dwes.AccesoManipulacionDatos.dto.LibroDto;
import com.dwes.AccesoManipulacionDatos.dto.LibrosDto;
import com.dwes.AccesoManipulacionDatos.model.Libro;
import com.dwes.AccesoManipulacionDatos.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/libros")
public class LibroController {
    private final LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public ResponseEntity<LibrosDto> getAllLibros() {
        LibrosDto librosDto = libroService.getAllLibros();
        return librosDto == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(librosDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDto> getLibroById(@PathVariable Long id) {
        Libro libro = libroService.getLibroById(id);
        if (libro == null) return ResponseEntity.notFound().build();
        LibroDto libroDto = new LibroDto(libro.getTitulo(), libro.getAutor());
        return ResponseEntity.ok(libroDto);
    }

    @PutMapping("/add")
    public ResponseEntity<LibroDto> addLibro(@RequestBody Libro libro) {
        Libro l = libroService.addLibro(libro);
        if (l == null) return ResponseEntity.badRequest().build();
        LibroDto libroDto = new LibroDto(l.getTitulo(), l.getAutor());
        return ResponseEntity.ok(libroDto);
    }

    @PatchMapping("/editar")
    public ResponseEntity<LibroDto> editarLibro(@RequestBody Libro libro) {
        return libroService.existeLibro(libro) ?
                this.addLibro(libro) :
                ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<LibroDto> eliminarLibro(@PathVariable Long id) {
        Libro libro;
        try {
            libro = libroService.eliminarLibro(id);
        } catch (Throwable t) {
            return ResponseEntity.badRequest().build();
        }
        LibroDto libroDto = new LibroDto(libro.getTitulo(), libro.getAutor());
        return ResponseEntity.ok(libroDto);
    }
}
