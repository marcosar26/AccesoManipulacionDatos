package com.dwes.AccesoManipulacionDatos.repository;

import com.dwes.AccesoManipulacionDatos.model.Vuelo;
import jakarta.annotation.Nonnull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VueloRepository extends CrudRepository<Vuelo, Long> {
    @Nonnull
    List<Vuelo> findAll();

    Vuelo findVueloById(Long id);
}