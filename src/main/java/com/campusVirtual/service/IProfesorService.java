package com.campusVirtual.service;

import java.util.List;

import com.campusVirtual.dto.CursoDto;
import com.campusVirtual.dto.ProfesorDto;
import com.campusVirtual.model.Profesor;

public interface IProfesorService {
    
    public Profesor saveProfesorNoDto(Profesor profesor);
    
    public Profesor getProfesorNoDtoById(Long id);
    
    public ProfesorDto saveProfesorDto(ProfesorDto profesorDto);
    
    public ProfesorDto getProfesorDtoById(Long id);

    public List<ProfesorDto> getAllProfesorDto();

    public List<CursoDto> getAllCursosProfesor(Long idProfesor);

    public void deleteProfesorById(Long idProfesor);

    public boolean existsProfesorById(Long idProfesor);
}
