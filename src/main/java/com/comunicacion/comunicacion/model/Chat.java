package com.comunicacion.comunicacion.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChat;

    @Column(length = 500, nullable = false)
    private String mensaje;

    @Column(length = 100)
    private String autor;

    @ManyToOne
    @JoinColumn(name = "id_foro", nullable = false)
    @JsonBackReference("foro-chat")
    private Foro foro;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("chat-comentario")
    private List<Comentario> comentarios;
}

