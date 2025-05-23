package com.edutech.edutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.edutech.edutech.model.Foro;

@Repository
public interface ForoRepository extends JpaRepository<Foro, Long> {
}

