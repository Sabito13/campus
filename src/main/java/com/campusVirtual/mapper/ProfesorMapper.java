package com.campusVirtual.mapper;

import java.util.ArrayList;
import java.util.List;

import com.campusVirtual.dto.ProfesorDto;
import com.campusVirtual.model.Profesor;

public class ProfesorMapper {

    public Profesor profesorDtoToProfesor(ProfesorDto profesorDto) {
        Profesor profesor = new Profesor(
            profesorDto.getNombre(),
            profesorDto.getEspecialidad()
        );

        return profesor;
    }

    public ProfesorDto profesorToProfesorDto(Profesor profesor) {
        ProfesorDto profesorDto = new ProfesorDto();

        profesorDto.setId(profesor.getId());
        profesorDto.setNombre(profesor.getNombre());
        profesorDto.setEspecialidad(profesor.getEspecialidad());

        return profesorDto;
    }

    public List<ProfesorDto> manyProfesorToProfesorDto(List<Profesor> profesores) {
        List<ProfesorDto>profesorDtos=new ArrayList<>();
        
        for (Profesor profesor : profesores) {
            profesorDtos.add(profesorToProfesorDto(profesor));
        }

        return profesorDtos;
    }
    
}
