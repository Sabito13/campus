package com.campusVirtual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.model.Profesor;
import com.campusVirtual.repository.ProfesorRepository;

@Service
public class ProfesorService {
    
    ProfesorRepository profesorRepository;

    @Autowired
    public ProfesorService( ProfesorRepository profesorRepository){
        this.profesorRepository=profesorRepository;
    }

    public Profesor guardarProfesorBd(Profesor profesor){
        return this.profesorRepository.save(profesor);
    }
}
