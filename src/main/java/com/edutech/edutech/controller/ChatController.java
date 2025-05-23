package com.edutech.edutech.controller;

import com.edutech.edutech.model.Chat;
import com.edutech.edutech.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foros/{idForo}/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public Chat crearChat(@PathVariable Long idForo, @RequestBody Chat chat) {
        return chatService.crearChat(idForo, chat);
    }

    @GetMapping
    public List<Chat> listarChats(@PathVariable Long idForo) {
        return chatService.obtenerChatsPorForo(idForo);
    }

    @GetMapping("/{idChat}")
    public Chat obtenerChatPorId(@PathVariable Long idChat) {
        return chatService.obtenerChatPorId(idChat);
    }

    @DeleteMapping("/{idChat}")
    public void eliminarChat(@PathVariable Long idChat) {
        chatService.eliminarChat(idChat);
    }
}

