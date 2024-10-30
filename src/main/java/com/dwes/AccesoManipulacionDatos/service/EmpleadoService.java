package com.dwes.AccesoManipulacionDatos.service;

import com.dwes.AccesoManipulacionDatos.dto.EmpleadoDto;
import com.dwes.AccesoManipulacionDatos.dto.HistoricoEmpleadoRequestDTO;
import com.dwes.AccesoManipulacionDatos.model.Empleado;
import com.dwes.AccesoManipulacionDatos.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    private EmpleadoDto mapToDto(Empleado empleado) {
        return new EmpleadoDto(empleado.getNombre(), empleado.getApellido(), empleado.getCorreo_electronico());
    }

    public List<EmpleadoDto> findAll() {
        return empleadoRepository.findAll().stream().map(this::mapToDto).toList();
    }

    public List<Empleado> getAllData() {
        return empleadoRepository.findAll().stream().toList();
    }

    public EmpleadoDto addEmpleado(Empleado empleado) {
        return mapToDto(empleadoRepository.save(empleado));
    }

    public EmpleadoDto eliminarEmpleado(Long id) {
        Optional<Empleado> op = empleadoRepository.findById(id);
        if (op.isEmpty()) return null;
        Empleado empleado = op.get();
        empleadoRepository.delete(empleado);
        return mapToDto(empleado);
    }

    public HistoricoEmpleadoRequestDTO getHistoricoEmpleadoRequestDTO() {
        List<Empleado> empleados = empleadoRepository.findAll();
        double salario_medio = empleados.stream().mapToDouble(Empleado::getSalario).average().orElseThrow();
        double salario_maximo = empleados.stream().mapToDouble(Empleado::getSalario).max().orElseThrow();
        double salario_minimo = empleados.stream().mapToDouble(Empleado::getSalario).min().orElseThrow();
        List<EmpleadoDto> emp = empleadoRepository.findByApellidoEquals("Llano").stream().map(this::mapToDto).toList();
        return new HistoricoEmpleadoRequestDTO(
                salario_medio,
                salario_maximo,
                salario_minimo,
                emp
        );
    }
}
