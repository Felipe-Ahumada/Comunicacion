package com.comunicacion.comunicacion.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentario;

    @Column(length = 500, nullable = false)
    private String contenido;

    @Column(nullable = false)
    private int rating;

    @Column(length = 100)
    private String autor;

    @ManyToOne
    @JoinColumn(name = "id_foro")
    @JsonBackReference("foro-comentario")
    private Foro foro;

    @ManyToOne
    @JoinColumn(name = "id_chat")
    @JsonBackReference("chat-comentario")
    private Chat chat;
}

