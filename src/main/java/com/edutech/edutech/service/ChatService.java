package com.edutech.edutech.service;

import com.edutech.edutech.model.Chat;
import com.edutech.edutech.model.Foro;
import com.edutech.edutech.repository.ChatRepository;
import com.edutech.edutech.repository.ForoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private ForoRepository foroRepository;

    public Chat crearChat(Long idForo, Chat chat) {
        Foro foro = foroRepository.findById(idForo).orElseThrow(() -> new RuntimeException("Foro no encontrado"));
        chat.setForo(foro);
        return chatRepository.save(chat);
    }

    public List<Chat> obtenerChatsPorForo(Long idForo) {
        Foro foro = foroRepository.findById(idForo).orElseThrow(() -> new RuntimeException("Foro no encontrado"));
        return chatRepository.findByForo(foro);
    }

    public Chat obtenerChatPorId(Long id) {
        return chatRepository.findById(id).orElse(null);
    }

    public void eliminarChat(Long id) {
        chatRepository.deleteById(id);
    }
}

