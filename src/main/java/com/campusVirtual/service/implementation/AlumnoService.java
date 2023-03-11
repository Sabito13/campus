package com.campusVirtual.service.implementation;

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
import com.campusVirtual.service.IAlumnoService;

@Service
public class AlumnoService implements IAlumnoService {
    private AlumnoMapper alumnoMapper = new AlumnoMapper();
    private CursoMapper cursoMapper = new CursoMapper();

    @Autowired
    private AlumnoRepository alumnoRepository;

  

    @Override
    public Alumno saveAlumnoNoDto(Alumno alumno){
        return this.alumnoRepository.save(alumno);
    }

    @Override
    public Alumno getAlumnoNoDtoById(Long idAlumno){
       return this.alumnoRepository.findById(idAlumno).orElseThrow(()-> new AlumnoNotFoundException(idAlumno));
    }

    @Override
    public AlumnoDto saveAlumnoDto(AlumnoDto alumnoDto){
        Alumno alumno= this.alumnoMapper.alumnoDtoToAlumno(alumnoDto);

        alumno = this.alumnoRepository.save(alumno);

        return this.alumnoMapper.alumnoToAlumnoDto(alumno);
    }

    @Override
    public AlumnoDto getAlumnoDtoById(Long idAlumno){
        Alumno alumno = this.alumnoRepository.findById(idAlumno).orElseThrow(()-> new AlumnoNotFoundException(idAlumno));
        
        AlumnoDto alumnoDto = this.alumnoMapper.alumnoToAlumnoDto(alumno);

        return alumnoDto;
    }


    @Override
    public List<AlumnoDto> getAllAlumnoDto(){
        List<Alumno> alumnos= this.alumnoRepository.findAll();
        
        List<AlumnoDto> alumnosDto = this.alumnoMapper.manyAlumnoToAlumnoDto(alumnos);

        return alumnosDto;
    }

    @Override
    public List<CursoDto> getAllCursosAlumno(Long idAlumno){
        Alumno alumno = this.alumnoRepository.findById(idAlumno).get();
        
        List<CursoDto> cursosAlumnoById= cursoMapper.manyAlumnoEnCursoToCursoDto(alumno.getAlumnoEnCurso()); 
        
        return cursosAlumnoById;
    }
    
    @Override
    public void deleteAlumnoById(Long idAlumno){
        if(this.alumnoRepository.existsById(idAlumno)){
            this.alumnoRepository.deleteById(idAlumno);
        }else{
            throw new AlumnoNotFoundException(idAlumno);
        }
    }

    @Override
    public boolean existsAlumnoById(Long idAlumno) {
        return this.alumnoRepository.existsById(idAlumno);
    }
}
