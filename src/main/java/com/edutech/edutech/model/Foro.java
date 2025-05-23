package com.edutech.edutech.model;

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

    @Column(length = 100)
    private String categoria;
}
