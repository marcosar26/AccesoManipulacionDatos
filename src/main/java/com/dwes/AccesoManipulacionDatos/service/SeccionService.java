package com.dwes.AccesoManipulacionDatos.service;

import com.dwes.AccesoManipulacionDatos.dto.SeccionDto;
import com.dwes.AccesoManipulacionDatos.model.Empleado;
import com.dwes.AccesoManipulacionDatos.model.Seccion;
import com.dwes.AccesoManipulacionDatos.repository.SeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeccionService {
    private final SeccionRepository seccionRepository;

    @Autowired
    public SeccionService(SeccionRepository seccionRepository) {
        this.seccionRepository = seccionRepository;
    }

    private SeccionDto mapToDto(Seccion seccion) {
        return new SeccionDto(seccion.getNombre());
    }

    public List<SeccionDto> findAll() {
        return seccionRepository.findAll().stream().map(this::mapToDto).toList();
    }

    public SeccionDto addSeccion(Seccion seccion) {
        return mapToDto(seccionRepository.save(seccion));
    }

    public SeccionDto eliminarSeccion(Long id) {
        Optional<Seccion> op = seccionRepository.findById(id);
        if (op.isEmpty()) return null;
        Seccion seccion = op.get();
        seccionRepository.delete(seccion);
        return mapToDto(seccion);
    }

    public List<Empleado> buscarEmpleadosPorSeccion(Long id) {
        Optional<Seccion> op = seccionRepository.findById(id);
        if (op.isEmpty()) return List.of();
        Seccion seccion = op.get();
        return List.copyOf(seccion.getEmpleados());
    }
}
