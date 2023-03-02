package com.campusVirtual.mapper;

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
}
