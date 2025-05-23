package com.edutech.edutech.service;

import com.edutech.edutech.model.*;
import com.edutech.edutech.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private ForoRepository foroRepository;

    @Autowired
    private ChatRepository chatRepository;

    public Comentario comentarForo(Long idForo, Comentario comentario) {
        Foro foro = foroRepository.findById(idForo).orElseThrow(() -> new RuntimeException("Foro no encontrado"));
        comentario.setForo(foro);
        return comentarioRepository.save(comentario);
    }

    public Comentario comentarChat(Long idChat, Comentario comentario) {
        Chat chat = chatRepository.findById(idChat).orElseThrow(() -> new RuntimeException("Chat no encontrado"));
        comentario.setChat(chat);
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> obtenerComentariosDeForo(Long idForo) {
        Foro foro = foroRepository.findById(idForo).orElseThrow(() -> new RuntimeException("Foro no encontrado"));
        return comentarioRepository.findByForo(foro);
    }

    public List<Comentario> obtenerComentariosDeChat(Long idChat) {
        Chat chat = chatRepository.findById(idChat).orElseThrow(() -> new RuntimeException("Chat no encontrado"));
        return comentarioRepository.findByChat(chat);
    }

    public Comentario obtenerPorId(Long idComentario) {
        return comentarioRepository.findById(idComentario).orElse(null);
    }

    public void eliminarComentario(Long idComentario) {
        comentarioRepository.deleteById(idComentario);
    }
}

