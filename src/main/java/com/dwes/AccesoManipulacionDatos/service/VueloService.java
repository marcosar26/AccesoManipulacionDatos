package com.dwes.AccesoManipulacionDatos.service;

import com.dwes.AccesoManipulacionDatos.dto.VueloDto;
import com.dwes.AccesoManipulacionDatos.dto.VueloDto1;
import com.dwes.AccesoManipulacionDatos.model.Vuelo;
import com.dwes.AccesoManipulacionDatos.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloService {
    private final VueloRepository vueloRepository;

    @Autowired
    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    private VueloDto toDto(Vuelo vuelo) {
        return new VueloDto(vuelo.getOrigen(), vuelo.getDestino(), vuelo.getFecha_salida(), vuelo.getFecha_llegada());
    }

    private VueloDto1 toDto1(Vuelo vuelo) {
        int capacidad = vuelo.getCapacidad_asientos();
        double precio = vuelo.getPrecio();
        double total = ((precio * capacidad) / 12) * 1000;
        return new VueloDto1(vuelo.getId(), capacidad, precio, total);
    }

    public List<VueloDto1> findAll() {
        List<Vuelo> vuelos = vueloRepository.findAll();
        return vuelos.stream().map(this::toDto1).toList();
    }

    public VueloDto1 save(Vuelo vuelo) {
        Vuelo savedVuelo = vueloRepository.save(vuelo);
        return toDto1(savedVuelo);
    }

    public VueloDto1 actualizarVuelo(Long id, Vuelo vuelo) {
        Vuelo v = vueloRepository.findVueloById(id);
        if (vuelo == null) return null;
        if (!vuelo.getOrigen().isBlank()) v.setOrigen(vuelo.getOrigen());
        if (!vuelo.getDestino().isBlank()) v.setDestino(vuelo.getDestino());
        if (vuelo.getFecha_salida() != null) v.setFecha_salida(vuelo.getFecha_salida());
        if (vuelo.getFecha_llegada() != null) v.setFecha_llegada(vuelo.getFecha_llegada());
        if (vuelo.getCapacidad_asientos() > 0) v.setCapacidad_asientos(vuelo.getCapacidad_asientos());
        if (vuelo.getPrecio() >= 0) v.setPrecio(vuelo.getPrecio());
        return toDto1(vueloRepository.save(v));
    }

    public VueloDto1 eliminarVuelo(Long id) {
        Vuelo v = vueloRepository.findVueloById(id);
        if (v == null) return null;
        vueloRepository.delete(v);
        return toDto1(v);
    }
}
