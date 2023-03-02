package com.campusVirtual.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.model.Curso;
import com.campusVirtual.model.Ensenia;
import com.campusVirtual.model.Profesor;
import com.campusVirtual.repository.EnseniaRepository;
import com.campusVirtual.repository.ProfesorRepository;

@Service
public class EnseniaService {
    
    EnseniaRepository enseniaRepository;

    @Autowired
    public EnseniaService( EnseniaRepository enseniaRepository){
        this.enseniaRepository=enseniaRepository;
    }

    public Ensenia asignarProfesorCurso(Profesor profesor,Curso curso){
        Ensenia ensenia = new Ensenia(profesor, curso);
        return this.enseniaRepository.save(ensenia);
    }
}
