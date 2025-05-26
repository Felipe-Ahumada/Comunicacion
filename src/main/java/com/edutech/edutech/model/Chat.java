package com.edutech.edutech.model;

import java.util.List;

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
    private Foro foro;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios;
}

