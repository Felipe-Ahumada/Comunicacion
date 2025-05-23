package com.edutech.edutech.model;

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
    private Foro foro;

    @ManyToOne
    @JoinColumn(name = "id_chat")
    private Chat chat;
}

