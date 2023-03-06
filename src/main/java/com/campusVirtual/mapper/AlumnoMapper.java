package com.campusVirtual.mapper;

import java.util.ArrayList;
import java.util.List;

import com.campusVirtual.dto.AlumnoDto;
import com.campusVirtual.model.Alumno;

public class AlumnoMapper {

    public Alumno alumnoDtoToAlumno(AlumnoDto alumnoDto) {
        Alumno alumno = new Alumno(
            alumnoDto.getNombre()
        );

        return alumno;
    }

    public AlumnoDto alumnoToAlumnoDto(Alumno alumno) {
        AlumnoDto alumnoDto = new AlumnoDto();

        alumnoDto.setId(alumno.getId());
        alumnoDto.setNombre(alumno.getNombre());

        return alumnoDto;
    }

    public List<AlumnoDto> manyAlumnoToAlumnoDto(List<Alumno> alumnos) {
        List<AlumnoDto>alumnoDtos=new ArrayList<>();
        
        for (Alumno alumno : alumnos) {
            alumnoDtos.add(alumnoToAlumnoDto(alumno));
        }

        return alumnoDtos;
    }

}
    
