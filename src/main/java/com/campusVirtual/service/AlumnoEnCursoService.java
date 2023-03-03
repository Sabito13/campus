package com.campusVirtual.service;

import org.springframework.stereotype.Service;

import com.campusVirtual.model.Alumno;
import com.campusVirtual.model.AlumnoEnCurso;
import com.campusVirtual.model.Curso;
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

    public AlumnoEnCurso asignarAlumnoCurso(Long alumnoId,Long cursoId){
        Alumno alumno = this.alumnoService.getAlumnoNoDtoById(alumnoId);
        Curso curso = this.cursoService.getCursoNoDtoById(cursoId);

        AlumnoEnCurso alumnoEnCurso = new AlumnoEnCurso();
        alumnoEnCurso.setAlumno(alumno);
        alumnoEnCurso.setCurso(curso);

        alumnoEnCurso = this.alumnoEnCursoRepository.save(alumnoEnCurso);

        alumno.addAlumnoEnCurso(alumnoEnCurso);
        curso.addAlumnoEnCurso(alumnoEnCurso);

        cursoService.saveCursoNoDto(curso);
        alumnoService.saveAlumnoNoDto(alumno);
    
        return alumnoEnCurso;
    }

}
