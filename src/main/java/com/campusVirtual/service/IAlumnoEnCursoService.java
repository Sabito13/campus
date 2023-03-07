package com.campusVirtual.service;

import com.campusVirtual.dto.AlumnoEnCursoDto;

public interface IAlumnoEnCursoService{
    public AlumnoEnCursoDto asignarAlumnoCurso(Long alumnoId,Long cursoId);
    
    public void desvincularAlumnoCurso(Long idAlumno, Long idCurso);
       
}