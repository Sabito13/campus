package com.campusVirtual.service.implementation;


import org.springframework.stereotype.Service;

import com.campusVirtual.dto.AlumnoEnCursoDto;
import com.campusVirtual.exception.AlumnoNotFoundException;
import com.campusVirtual.exception.CursoNotFoundException;
import com.campusVirtual.mapper.AlumnoEnCursoMapper;
import com.campusVirtual.model.Alumno;
import com.campusVirtual.model.AlumnoEnCurso;
import com.campusVirtual.model.Curso;
import com.campusVirtual.repository.AlumnoEnCursoRepository;
import com.campusVirtual.service.IAlumnoEnCursoService;
import com.campusVirtual.service.IAlumnoService;
import com.campusVirtual.service.ICursoService;

@Service
public class AlumnoEnCursoService  implements IAlumnoEnCursoService{
    private AlumnoEnCursoMapper alumnoEnCursoMapper = new AlumnoEnCursoMapper();
    private IAlumnoService alumnoService;
    private ICursoService cursoService;
    private AlumnoEnCursoRepository alumnoEnCursoRepository;

    public AlumnoEnCursoService(
        IAlumnoService alumnoService,
        ICursoService cursoService,
        AlumnoEnCursoRepository alumnoEnCursoRepository
    ){
        this.alumnoService=alumnoService;
        this.cursoService=cursoService;
        this.alumnoEnCursoRepository=alumnoEnCursoRepository;
    }

    @Override
    public AlumnoEnCursoDto asignarAlumnoCurso(Long alumnoId,Long cursoId){
        Alumno alumno = this.alumnoService.getAlumnoNoDtoById(alumnoId);
        Curso curso = this.cursoService.getCursoNoDtoById(cursoId);

        AlumnoEnCurso alumnoEnCurso = new AlumnoEnCurso();
        alumnoEnCurso.setAlumno(alumno);
        alumnoEnCurso.setCurso(curso);

        alumnoEnCurso = this.alumnoEnCursoRepository.save(alumnoEnCurso);

        alumno.addAlumnoEnCurso(alumnoEnCurso);
        curso.addAlumnoEnCurso(alumnoEnCurso);

        cursoService.saveCursoNoDto(curso);
        alumnoService.saveAlumnoNoDto(alumno);
    
        return alumnoEnCursoMapper.alumnoEnCursoToDto(alumnoEnCurso);
    }

    @Override
    public void desvincularAlumnoCurso(Long idAlumno, Long idCurso) {
        if(!this.alumnoService.existsAlumnoById(idAlumno)){
            throw new AlumnoNotFoundException(idAlumno);
        }

        if(!this.cursoService.existsCursoById(idCurso)){
            throw new CursoNotFoundException(idCurso);
        }
       
        this.alumnoEnCursoRepository.deleteAlumnoEnCursoByBothId(idAlumno,idCurso);
    }
}

    

   


