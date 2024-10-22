package com.dwes.AccesoManipulacionDatos.repository;

import com.dwes.AccesoManipulacionDatos.model.Libro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends CrudRepository<Libro, Long> {
    Libro getLibroById(Long id);
    List<Libro> findAll();
}