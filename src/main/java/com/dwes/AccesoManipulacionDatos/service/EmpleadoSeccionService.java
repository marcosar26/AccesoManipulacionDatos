package com.dwes.AccesoManipulacionDatos.service;

import com.dwes.AccesoManipulacionDatos.model.Empleado;
import com.dwes.AccesoManipulacionDatos.model.Seccion;
import com.dwes.AccesoManipulacionDatos.repository.EmpleadoRepository;
import com.dwes.AccesoManipulacionDatos.repository.SeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpleadoSeccionService {
    private final EmpleadoRepository empleadoRepository;
    private final SeccionRepository seccionRepository;

    @Autowired
    public EmpleadoSeccionService(EmpleadoRepository empleadoRepository, SeccionRepository seccionRepository) {
        this.empleadoRepository = empleadoRepository;
        this.seccionRepository = seccionRepository;
    }

    public Empleado asignarSeccion(Long empleadoId, Long seccionId) {
        Optional<Empleado> empleadoOpt = empleadoRepository.findById(empleadoId);
        Optional<Seccion> seccionOpt = seccionRepository.findById(seccionId);

        if (empleadoOpt.isEmpty() || seccionOpt.isEmpty()) {
            throw new IllegalArgumentException("No se encontro el empleado o la seccion");
        }

        Empleado empleado = empleadoOpt.get();
        Seccion seccion = seccionOpt.get();

        empleado.getSecciones().add(seccion);

        empleadoRepository.save(empleado);

        return empleado;
    }
}
