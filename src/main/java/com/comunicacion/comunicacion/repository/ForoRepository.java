package com.comunicacion.comunicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comunicacion.comunicacion.model.Foro;

@Repository
public interface ForoRepository extends JpaRepository<Foro, Long> {
}

