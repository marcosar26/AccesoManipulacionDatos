package com.dwes.AccesoManipulacionDatos.repository;

import com.dwes.AccesoManipulacionDatos.model.Empleado;
import jakarta.annotation.Nonnull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
    @Nonnull
    List<Empleado> findAll();
    List<Empleado> findByApellidoEquals(String apellido);
}