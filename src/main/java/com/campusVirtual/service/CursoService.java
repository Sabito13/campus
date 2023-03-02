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


    public void saveCursoDto(CursoDto cursoDto) {
       Curso nuevoCurso = cursoMapper.cursoDtoToCurso(cursoDto);
       this.cursoRepository.save(nuevoCurso);
    }

    public Curso saveCursoNoDto(Curso curso){
        return this.cursoRepository.save(curso);
    }


    public Curso getCursoNoDtoById(Long id){
        return this.cursoRepository.findById(id).get();
    }

    public CursoDto getCursoDtoById(Long id){
        Curso curso = this.cursoRepository.findById(id).get();
        return cursoMapper.cursoToCursoDto(curso); 
    }


    public List<CursoDto> getAllCursosDto(){
        List<CursoDto> cursoDto = cursoMapper.manyCursoToCursoDto(
            this.cursoRepository.findAll());
        
      return cursoDto;
    } 

   
    
}
