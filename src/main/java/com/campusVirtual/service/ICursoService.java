package com.campusVirtual.service;

import java.util.List;

import com.campusVirtual.dto.CursoDto;
import com.campusVirtual.dto.ProfesorDto;
import com.campusVirtual.model.Curso;

public interface ICursoService {
    
    public CursoDto saveCursoDto(CursoDto cursoDto) ;
 
     public Curso saveCursoNoDto(Curso curso);
 
     public Curso getCursoNoDtoById(Long id);
 
     public CursoDto getCursoDtoById(Long id);

     public List<CursoDto> getAllCursosDto();
 
     public void deleteCursoById(Long idCurso);
     
     public boolean existsCursoById(Long idCurso);

     public List<ProfesorDto> getAllProfesoresOfCurso(Long idCurso);

     
}
