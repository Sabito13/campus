package com.campusVirtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.campusVirtual.mapper.AlumnoMapper;
import com.campusVirtual.mapper.CursoMapper;
import com.campusVirtual.dto.AlumnoDto;
import com.campusVirtual.dto.CursoDto;
import com.campusVirtual.exception.AlumnoNotFoundException;
import com.campusVirtual.model.Alumno;
import com.campusVirtual.repository.AlumnoRepository;

@Service
public class AlumnoService {
    private AlumnoMapper alumnoMapper = new AlumnoMapper();
    private CursoMapper cursoMapper = new CursoMapper();

    private AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoService(
        AlumnoRepository alumnoRepository){
        this.alumnoRepository=alumnoRepository;
    }

    public Alumno saveAlumnoNoDto(Alumno alumno){
        return this.alumnoRepository.save(alumno);
    }


    public Alumno getAlumnoNoDtoById(Long idAlumno){
       return this.alumnoRepository.findById(idAlumno).orElseThrow(()-> new AlumnoNotFoundException(idAlumno));
    }


    public AlumnoDto saveAlumnoDto(AlumnoDto alumnoDto){
        Alumno alumno= this.alumnoMapper.alumnoDtoToAlumno(alumnoDto);

        alumno = this.alumnoRepository.save(alumno);

        return this.alumnoMapper.alumnoToAlumnoDto(alumno);
    }


    public AlumnoDto getAlumnoDtoById(Long idAlumno){
        Alumno alumno = this.alumnoRepository.findById(idAlumno).orElseThrow(()-> new AlumnoNotFoundException(idAlumno));
        
        AlumnoDto alumnoDto = this.alumnoMapper.alumnoToAlumnoDto(alumno);

        return alumnoDto;
    }



    public List<AlumnoDto> getAllAlumnoDto(){
        List<Alumno> alumnos= this.alumnoRepository.findAll();
        
        List<AlumnoDto> alumnosDto = this.alumnoMapper.manyAlumnoToAlumnoDto(alumnos);

        return alumnosDto;
    }

    public List<CursoDto> getAllCursosAlumno(Long idAlumno){
        Alumno alumno = this.alumnoRepository.findById(idAlumno).get();
        
        List<CursoDto> cursosAlumnoById= cursoMapper.manyAlumnoEnCursoToCursoDto(alumno.getAlumnoEnCurso()); 
        
        return cursosAlumnoById;
    }
    

    public void deleteAlumnoById(Long idAlumno){
        if(this.alumnoRepository.existsById(idAlumno)){
            this.alumnoRepository.deleteById(idAlumno);
        }else{
            throw new AlumnoNotFoundException(idAlumno);
        }
    }

    public boolean existsAlumnoById(Long idAlumno) {
        return this.alumnoRepository.existsById(idAlumno);
    }
}
