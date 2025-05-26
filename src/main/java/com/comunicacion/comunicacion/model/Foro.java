package com.comunicacion.comunicacion.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "foro")
public class Foro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idForo;

    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(length = 500)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoriaForo categoria;

    @OneToMany(mappedBy = "foro", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("foro-chat")
    private List<Chat> chats;

    @OneToMany(mappedBy = "foro", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("foro-comentario")
    private List<Comentario> comentarios;
}
