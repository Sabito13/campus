package com.campusVirtual.mapper;

import java.util.ArrayList;
import java.util.List;

import com.campusVirtual.dto.CursoDto;
import com.campusVirtual.model.Curso;

public class CursoMapper {

    public Curso cursoDtoToCurso(CursoDto cursoDto) {
        Curso nuevoCurso = new Curso(cursoDto.getNombre());
        return nuevoCurso;
    }

    public CursoDto cursoToCursoDto(Curso curso){
       CursoDto cursoDto= new CursoDto(curso.getId(),curso.getNombre());
    
       return cursoDto;
    }

    public List<CursoDto> manyCursoToCursoDto(List<Curso>  cursos) {
        List<CursoDto> cursosDtos = new ArrayList<>();
        
        for (Curso curso : cursos) {
            cursosDtos.add(
                cursoToCursoDto(curso)
            );
        }

        return cursosDtos;
    }
    
}
