package com.campusVirtual.mapper;

import java.util.ArrayList;
import java.util.List;

import com.campusVirtual.dto.AlumnoEnCursoDto;
import com.campusVirtual.model.AlumnoEnCurso;

public class AlumnoEnCursoMapper {
    
    
    public AlumnoEnCursoDto  alumnoEnCursoToDto(AlumnoEnCurso aecNoDto){
        AlumnoEnCursoDto  aecdto=new AlumnoEnCursoDto();
        aecdto.setId(aecNoDto.getId());
        aecdto.setAlumnoId(aecNoDto.getAlumno().getId());
        aecdto.setAlumnoNombre(aecNoDto.getAlumno().getNombre());
        aecdto.setCursoId(aecNoDto.getCurso().getId());
        aecdto.setCursoNombre(aecNoDto.getCurso().getNombre());

        return aecdto;
    }



    public List<AlumnoEnCursoDto> manyAlumnoEnCursoToDto(List<AlumnoEnCurso> aecNoDtos) {
        List<AlumnoEnCursoDto> aecdtos = new ArrayList<>();

        for (AlumnoEnCurso alumnoEnCurso : aecNoDtos) {
            aecdtos.add(alumnoEnCursoToDto(alumnoEnCurso));
        }

        return aecdtos;
    }
    
}
