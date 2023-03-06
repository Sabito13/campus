package com.campusVirtual.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.dto.ProfesorEnCursoDto;
import com.campusVirtual.mapper.ProfesorEnCursoMapper;
import com.campusVirtual.model.Curso;
import com.campusVirtual.model.ProfesorEnCurso;
import com.campusVirtual.model.Profesor;
import com.campusVirtual.repository.ProfesorEnCursoRepository;

@Service
public class ProfesorEnCursoService {
    
    private ProfesorEnCursoRepository profesorEnCursoRepository;
    private ProfesorService profesorService;
    private CursoService cursoService;
    private ProfesorEnCursoMapper pecMapper= new ProfesorEnCursoMapper();
    

    @Autowired
    public ProfesorEnCursoService( 
        ProfesorEnCursoRepository profesorEnCursoRepository,
        ProfesorService profesorService,
        CursoService cursoService){
        this.profesorEnCursoRepository=profesorEnCursoRepository;
        this.profesorService=profesorService;
        this.cursoService=cursoService;
    }

    //public ProfesorEnCurso asignarProfesorCurso(Profesor profesor,Curso curso){
    //    ProfesorEnCurso ensenia = new ProfesorEnCurso(profesor, curso);
    //    return this.profesorEnCursoRepository.save(ensenia);
    //}

    public ProfesorEnCursoDto asignarProfesorCurso(Long idProfesor,Long Idcurso){
        Profesor profesorPorId=profesorService.getProfesorNoDtoById(idProfesor);
        Curso cursoPorId=cursoService.getCursoNoDtoById(Idcurso);
        
        ProfesorEnCurso profesorCursoRelacion = new ProfesorEnCurso(profesorPorId, cursoPorId);
        profesorCursoRelacion =  this.profesorEnCursoRepository.save(profesorCursoRelacion);

        profesorPorId.addProfesorEnCurso(profesorCursoRelacion);
        cursoPorId.addProfesorEnCurso(profesorCursoRelacion);

        profesorService.saveProfesorNoDto(profesorPorId);
        cursoService.saveCursoNoDto(cursoPorId); 

        return  pecMapper.profesorEnCursoToDto(profesorCursoRelacion);  
    }

    public List<ProfesorEnCursoDto> getAllPecDto() {
        List<ProfesorEnCurso> pecs=profesorEnCursoRepository.findAll();
        return pecMapper.manyProfesorEnCursoToDto(pecs);
    }
}
