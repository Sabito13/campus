package com.campusVirtual.mapper;

import java.util.ArrayList;
import java.util.List;

import com.campusVirtual.dto.ProfesorEnCursoDto;
import com.campusVirtual.model.ProfesorEnCurso;

public class ProfesorEnCursoMapper {
    public ProfesorEnCursoDto profesorEnCursoToDto(ProfesorEnCurso profesorEnCurso){
       ProfesorEnCursoDto pecdto = new ProfesorEnCursoDto();

        pecdto.setId(profesorEnCurso.getId());
        pecdto.setProfesorId(profesorEnCurso.getProfesor().getId());
        pecdto.setCursoId(profesorEnCurso.getCurso().getId());
        pecdto.setProfesorNombre(profesorEnCurso.getProfesor().getNombre());
        pecdto.setCursoNombre(profesorEnCurso.getCurso().getNombre());
        return pecdto;
    }

    public List<ProfesorEnCursoDto> manyProfesorEnCursoToDto(List<ProfesorEnCurso> pecs) {
       List<ProfesorEnCursoDto> profesorEnCursoDtos =new ArrayList<>();
       
        for (ProfesorEnCurso profesorEnCurso : pecs) {
            profesorEnCursoDtos.add(profesorEnCursoToDto(profesorEnCurso));
       }
       return profesorEnCursoDtos;
    }
}
