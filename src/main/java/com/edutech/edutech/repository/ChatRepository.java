package com.edutech.edutech.repository;

import com.edutech.edutech.model.Chat;
import com.edutech.edutech.model.Foro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findByForo(Foro foro);
}

