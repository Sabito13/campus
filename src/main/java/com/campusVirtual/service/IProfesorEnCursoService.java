package com.campusVirtual.service;

import com.campusVirtual.dto.ProfesorEnCursoDto;

public interface IProfesorEnCursoService {

    public ProfesorEnCursoDto asignarProfesorCurso(Long idProfesor,Long Idcurso);
        
    public void desvincularProfesorCurso(Long idProfesor, Long idCurso);
        
}
