package com.campusVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusVirtual.model.Alumno;

public interface AlumnoEnCursoRepository extends JpaRepository<Alumno,Long> {
     
}
