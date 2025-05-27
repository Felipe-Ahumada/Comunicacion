package com.comunicacion.comunicacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.comunicacion.comunicacion.model.Foro;
import com.comunicacion.comunicacion.service.ForoService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/foros")
public class ForoController {

    @Autowired
    private ForoService foroService;

    @PostMapping
    public ResponseEntity<?> crearForo(@RequestBody Foro foro) {
        try {
            Foro nuevo = foroService.crearForo(foro);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<Foro>> listarForos() {
        List<Foro> foros = foroService.obtenerTodosLosForos();
        return foros.isEmpty()
            ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
            : new ResponseEntity<>(foros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Foro> obtenerPorId(@PathVariable Long id) {
        Foro foro = foroService.obtenerForoPorId(id);
        return foro == null
            ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
            : new ResponseEntity<>(foro, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Foro foro = foroService.obtenerForoPorId(id);
        if (foro == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        foroService.eliminarForo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
