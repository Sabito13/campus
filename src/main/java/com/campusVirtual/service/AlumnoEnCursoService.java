package com.campusVirtual.service;

import org.springframework.stereotype.Service;

import com.campusVirtual.repository.AlumnoEnCursoRepository;

@Service
public class AlumnoEnCursoService {
    
    private AlumnoService alumnoService;
    private CursoService cursoService;
    private AlumnoEnCursoRepository alumnoEnCursoRepository;

    public AlumnoEnCursoService(
        AlumnoService alumnoService,
        CursoService cursoService,
        AlumnoEnCursoRepository alumnoEnCursoRepository
    ){
        this.alumnoService=alumnoService;
        this.cursoService=cursoService;
        this.alumnoEnCursoRepository=alumnoEnCursoRepository;
    }
}
