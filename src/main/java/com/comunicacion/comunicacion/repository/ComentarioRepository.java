package com.comunicacion.comunicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comunicacion.comunicacion.model.Chat;
import com.comunicacion.comunicacion.model.Comentario;
import com.comunicacion.comunicacion.model.Foro;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByForo(Foro foro);
    List<Comentario> findByChat(Chat chat);
}

