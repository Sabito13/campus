package com.campusVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusVirtual.model.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno,Long>{
    
}
