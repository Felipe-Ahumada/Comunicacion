package com.comunicacion.comunicacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.comunicacion.comunicacion.model.Chat;
import com.comunicacion.comunicacion.service.ChatService;

import java.util.List;

@RestController
@RequestMapping("/api/foros/{idForo}/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public ResponseEntity<Chat> crearChat(@PathVariable Long idForo, @RequestBody Chat chat) {
        
        chat.setAutor("Pedrito quinto b");

        Chat creado = chatService.crearChat(idForo, chat);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Chat>> listarChats(@PathVariable Long idForo) {
        List<Chat> chats = chatService.obtenerChatsPorForo(idForo);
        return chats.isEmpty()
            ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
            : new ResponseEntity<>(chats, HttpStatus.OK);
    }

    @GetMapping("/{idChat}")
    public ResponseEntity<Chat> obtenerChatPorId(@PathVariable Long idChat) {
        Chat chat = chatService.obtenerChatPorId(idChat);
        return chat == null
            ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
            : new ResponseEntity<>(chat, HttpStatus.OK);
    }

    @DeleteMapping("/{idChat}")
    public ResponseEntity<Void> eliminarChat(@PathVariable Long idChat) {
        Chat chat = chatService.obtenerChatPorId(idChat);
        if (chat == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        chatService.eliminarChat(idChat);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
