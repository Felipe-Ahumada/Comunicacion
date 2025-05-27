package com.comunicacion.comunicacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comunicacion.comunicacion.model.Foro;
import com.comunicacion.comunicacion.repository.ForoRepository;

import java.util.List;

@Service
public class ForoService {

    @Autowired
    private ForoRepository foroRepository;

    public Foro crearForo(Foro foro) {
    if (foroRepository.existsByTituloIgnoreCase(foro.getTitulo())) {
        throw new RuntimeException("Ya existe un foro con ese título.");
    }
    return foroRepository.save(foro);
}

    public List<Foro> obtenerTodosLosForos() {
        return foroRepository.findAll();
    }

    public Foro obtenerForoPorId(Long id) {
        return foroRepository.findById(id).orElse(null);
    }

    public void eliminarForo(Long id) {
        foroRepository.deleteById(id);
    }
}
