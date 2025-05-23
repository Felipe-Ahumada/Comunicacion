package com.edutech.edutech.controller;

import com.edutech.edutech.model.Foro;
import com.edutech.edutech.service.ForoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foros")
public class ForoController {

    @Autowired
    private ForoService foroService;

    @PostMapping
    public Foro crearForo(@RequestBody Foro foro) {
        return foroService.crearForo(foro);
    }

    @GetMapping
    public List<Foro> listarForos() {
        return foroService.obtenerTodosLosForos();
    }

    @GetMapping("/{id}")
    public Foro obtenerPorId(@PathVariable Long id) {
        return foroService.obtenerForoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        foroService.eliminarForo(id);
    }
}
