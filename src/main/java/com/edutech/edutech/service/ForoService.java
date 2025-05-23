package com.edutech.edutech.service;

import com.edutech.edutech.model.Foro;
import com.edutech.edutech.repository.ForoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForoService {

    @Autowired
    private ForoRepository foroRepository;

    public Foro crearForo(Foro foro) {
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
