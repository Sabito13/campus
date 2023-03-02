package com.campusVirtual.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.model.Curso;
import com.campusVirtual.model.ProfesorEnCurso;
import com.campusVirtual.model.Profesor;
import com.campusVirtual.repository.ProfesorEnCursoRepository;

@Service
public class ProfesorEnCursoService {
    
    ProfesorEnCursoRepository profesorEnCursoRepository;

    @Autowired
    public ProfesorEnCursoService( ProfesorEnCursoRepository profesorEnCursoRepository){
        this.profesorEnCursoRepository=profesorEnCursoRepository;
    }

    public ProfesorEnCurso asignarProfesorCurso(Profesor profesor,Curso curso){
        ProfesorEnCurso ensenia = new ProfesorEnCurso(profesor, curso);
        return this.profesorEnCursoRepository.save(ensenia);
    }
}
