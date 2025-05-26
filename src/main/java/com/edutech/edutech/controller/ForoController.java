package com.edutech.edutech.controller;

import com.edutech.edutech.model.Foro;
import com.edutech.edutech.service.ForoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foros")
public class ForoController {

    @Autowired
    private ForoService foroService;

    @PostMapping
    public ResponseEntity<Foro> crearForo(@RequestBody Foro foro) {
        Foro creado = foroService.crearForo(foro);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
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
