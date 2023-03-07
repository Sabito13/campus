package com.campusVirtual.service;

import java.util.List;

import com.campusVirtual.dto.AlumnoDto;
import com.campusVirtual.dto.CursoDto;
import com.campusVirtual.model.Alumno;

public interface IAlumnoService {
    
    public Alumno saveAlumnoNoDto(Alumno alumno);

    public Alumno getAlumnoNoDtoById(Long idAlumno);

    public AlumnoDto saveAlumnoDto(AlumnoDto alumnoDto);

    public AlumnoDto getAlumnoDtoById(Long idAlumno);

    public List<AlumnoDto> getAllAlumnoDto();

    public List<CursoDto> getAllCursosAlumno(Long idAlumno);

    public void deleteAlumnoById(Long idAlumno);

    public boolean existsAlumnoById(Long idAlumno);
        
}


