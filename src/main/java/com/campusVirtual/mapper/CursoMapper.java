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

    public List<CursoDto> manyCursoToCursoDto(List<Curso>  cursos) {
        List<CursoDto> cursosDtos = new ArrayList<>();
        
        for (Curso curso : cursos) {
            cursosDtos.add(
                new CursoDto(curso.getId(),curso.getNombre())
            );
        }

        return cursosDtos;
    }
    
}
