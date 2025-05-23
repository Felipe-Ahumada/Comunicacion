package com.edutech.edutech.controller;

import com.edutech.edutech.model.Comentario;
import com.edutech.edutech.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping("/foros/{idForo}")
    public Comentario comentarForo(@PathVariable Long idForo, @RequestBody Comentario comentario) {
        return comentarioService.comentarForo(idForo, comentario);
    }

    @PostMapping("/chats/{idChat}")
    public Comentario comentarChat(@PathVariable Long idChat, @RequestBody Comentario comentario) {
        return comentarioService.comentarChat(idChat, comentario);
    }

    @GetMapping("/foros/{idForo}")
    public List<Comentario> listarComentariosDeForo(@PathVariable Long idForo) {
        return comentarioService.obtenerComentariosDeForo(idForo);
    }

    @GetMapping("/chats/{idChat}")
    public List<Comentario> listarComentariosDeChat(@PathVariable Long idChat) {
        return comentarioService.obtenerComentariosDeChat(idChat);
    }

    @GetMapping("/{idComentario}")
    public Comentario obtenerPorId(@PathVariable Long idComentario) {
        return comentarioService.obtenerPorId(idComentario);
    }

    @DeleteMapping("/{idComentario}")
    public void eliminarComentario(@PathVariable Long idComentario) {
        comentarioService.eliminarComentario(idComentario);
    }
}

