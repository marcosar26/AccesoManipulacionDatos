package com.dwes.AccesoManipulacionDatos.service;

import com.dwes.AccesoManipulacionDatos.dto.LibroDto;
import com.dwes.AccesoManipulacionDatos.dto.LibrosDto;
import com.dwes.AccesoManipulacionDatos.model.Libro;
import com.dwes.AccesoManipulacionDatos.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {
    private final LibroRepository libroRepository;

    @Autowired
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public LibrosDto getAllLibros() {
        List<Libro> libros = libroRepository.findAll();
        List<LibroDto> libroDtos = libros.stream().map(libro -> new LibroDto(libro.getTitulo(), libro.getAutor())).toList();
        int numPaginasTotales = 0;
        int cantidadTotal = 0;
        for (Libro libro : libros) {
            numPaginasTotales += libro.getNumPaginas();
            cantidadTotal += libro.getCantidad();
        }
        return new LibrosDto(libroDtos, numPaginasTotales, cantidadTotal);
    }

    public Libro getLibroById(Long id) {
        return libroRepository.getLibroById(id);
    }

    public Libro addLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public boolean existeLibro(Libro libro) {
        return libroRepository.existsById(libro.getId());
    }

    public Libro eliminarLibro(Long id) throws Throwable {
        Libro libro = libroRepository.getLibroById(id);
        try {
            libroRepository.delete(libro);
        } catch (Throwable t) {
            throw new Exception();
        }
        return libro;
    }
}
