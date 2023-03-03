package com.campusVirtual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.model.Alumno;
import com.campusVirtual.repository.AlumnoRepository;

@Service
public class AlumnoService {
    private AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoService(
        AlumnoRepository alumnoRepository
    ){
        this.alumnoRepository=alumnoRepository;
    }

    public Alumno saveCursoNoDto(Alumno alumno){
        return this.alumnoRepository.save(alumno);
    }


    public Alumno getAlumnoNoDtoById(Long idAlumno){
       return this.alumnoRepository.findById(idAlumno).get();
    }




}
