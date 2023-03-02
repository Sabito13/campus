package com.campusVirtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.dto.CursoDto;
import com.campusVirtual.mapper.CursoMapper;
import com.campusVirtual.model.Curso;
import com.campusVirtual.repository.CursoRepository;

@Service
public class CursoService {

    private CursoMapper cursoMapper = new CursoMapper();
    private CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository){
        this.cursoRepository=cursoRepository;
    }
    public void crearCurso(CursoDto cursoDto) {
       Curso nuevoCurso = cursoMapper.cursoDtoToCurso(cursoDto);
       this.cursoRepository.save(nuevoCurso);
    }

    public Curso crearCurso(Curso curso){
        return this.cursoRepository.save(curso);
    }


    public List<CursoDto> obtenerTodosLosCursos(){
        List<CursoDto> cursoDto = cursoMapper.manyCursoToCursoDto(
            this.cursoRepository.findAll());
        
      return cursoDto;

    } 
    
}
