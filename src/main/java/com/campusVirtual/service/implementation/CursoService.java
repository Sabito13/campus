package com.campusVirtual.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.dto.CursoDto;
import com.campusVirtual.dto.ProfesorDto;
import com.campusVirtual.exception.CursoNotFoundException;
import com.campusVirtual.mapper.CursoMapper;
import com.campusVirtual.mapper.ProfesorMapper;
import com.campusVirtual.model.Curso;
import com.campusVirtual.model.Profesor;
import com.campusVirtual.model.ProfesorEnCurso;
import com.campusVirtual.repository.CursoRepository;
import com.campusVirtual.service.ICursoService;

@Service
public class CursoService implements ICursoService {

    private CursoMapper cursoMapper = new CursoMapper();
    private ProfesorMapper profesorMapper = new ProfesorMapper();
    @Autowired
    private CursoRepository cursoRepository;

   

    @Override
    public CursoDto saveCursoDto(CursoDto cursoDto) {
       Curso nuevoCurso = cursoMapper.cursoDtoToCurso(cursoDto);
       nuevoCurso = this.cursoRepository.save(nuevoCurso);

       CursoDto cursoDtos=this.cursoMapper.cursoToCursoDto(nuevoCurso);
    
        return cursoDtos;
    }

    @Override
    public Curso saveCursoNoDto(Curso curso){
        return this.cursoRepository.save(curso);
    }

    @Override
    public Curso getCursoNoDtoById(Long id){
        return this.cursoRepository.findById(id).orElseThrow(()-> new CursoNotFoundException(id));
    }

    @Override
    public CursoDto getCursoDtoById(Long id){
        Curso curso = this.cursoRepository.findById(id).orElseThrow(()-> new CursoNotFoundException(id));;
        return cursoMapper.cursoToCursoDto(curso); 
    }

    @Override
    public List<CursoDto> getAllCursosDto(){
        List<CursoDto> cursoDto = cursoMapper.manyCursoToCursoDto(
            this.cursoRepository.findAll());
        
      return cursoDto; 
    } 

    @Override
    public void deleteCursoById(Long idCurso){
        if(this.cursoRepository.existsById(idCurso)){
            this.cursoRepository.deleteById(idCurso);
        }else{
            throw new CursoNotFoundException(idCurso);
        }
    }

    @Override
    public boolean existsCursoById(Long idCurso) {
        return this.cursoRepository.existsById(idCurso);
    }

   

    @Override
    public List<ProfesorDto> getAllProfesoresOfCurso(Long idCurso) {
        Curso curso = this.cursoRepository.findById(idCurso).orElseThrow(()-> new CursoNotFoundException(idCurso));
        
        List<ProfesorEnCurso> profesoresRelacion=curso.getProfesorEnCurso();
        
        List<Profesor> profesores=new ArrayList<>();
        for (ProfesorEnCurso profesor : profesoresRelacion) {
            profesores.add(profesor.getProfesor());
        }
        return this.profesorMapper.manyProfesorToProfesorDto(profesores);
    }

   
    
}
