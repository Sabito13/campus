package com.campusVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusVirtual.model.Curso;

public interface CursoRepository extends JpaRepository<Curso,Long> {
    
}
