package com.dwes.AccesoManipulacionDatos.repository;

import com.dwes.AccesoManipulacionDatos.model.Seccion;
import jakarta.annotation.Nonnull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeccionRepository extends CrudRepository<Seccion, Long> {
    @Nonnull
    List<Seccion> findAll();
}