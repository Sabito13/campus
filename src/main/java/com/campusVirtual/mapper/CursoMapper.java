package com.campusVirtual.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.campusVirtual.dto.CursoDto;
import com.campusVirtual.model.AlumnoEnCurso;
import com.campusVirtual.model.Curso;
import com.campusVirtual.model.ProfesorEnCurso;
import com.campusVirtual.service.ICursoService;

public class CursoMapper {

    @Autowired
    ICursoService cursoService;

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
    


    public List<CursoDto> manyAlumnoEnCursoToCursoDto(List<AlumnoEnCurso> alumnoEnCurso) {
        List<CursoDto> cursosDto = new ArrayList<CursoDto>();

        for (AlumnoEnCurso aec : alumnoEnCurso) {
            cursosDto.add(
                cursoToCursoDto(aec.getCurso())
            );
        }
        
        return cursosDto;
    }


    public List<CursoDto> manyProfesorEnCursoToCursoDto(List<ProfesorEnCurso> profesorEnCurso) {
        List<CursoDto> cursosDto = new ArrayList<CursoDto>();
        
        for (ProfesorEnCurso pec : profesorEnCurso) {
            cursosDto.add(
                cursoToCursoDto(pec.getCurso())
            );
        }
        
        return cursosDto;
    }
}
