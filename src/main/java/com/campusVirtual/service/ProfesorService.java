package com.campusVirtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.dto.CursoDto;
import com.campusVirtual.dto.ProfesorDto;
import com.campusVirtual.exception.ProfesorNotFoundException;
import com.campusVirtual.mapper.ProfesorMapper;
import com.campusVirtual.mapper.CursoMapper;
import com.campusVirtual.model.Profesor;
import com.campusVirtual.repository.ProfesorRepository;

@Service
public class ProfesorService {
    
    ProfesorRepository profesorRepository;
    ProfesorMapper profesorMapper = new ProfesorMapper();
    private CursoMapper cursoMapper = new CursoMapper();

    @Autowired
    public ProfesorService( ProfesorRepository profesorRepository){
        this.profesorRepository=profesorRepository;
    }

    
    public Profesor saveProfesorNoDto(Profesor profesor) {
        return this.profesorRepository.save(profesor);
    }
    
    public Profesor getProfesorNoDtoById(Long id) {
        return this.profesorRepository.findById(id).orElseThrow(()-> new ProfesorNotFoundException(id));
    }
    
    
    public ProfesorDto saveProfesorDto(ProfesorDto profesorDto) {
        Profesor profesor = this.profesorMapper.profesorDtoToProfesor(profesorDto);
        
        profesor = this.profesorRepository.save(profesor);

        ProfesorDto profesorDtoCreado = this.profesorMapper.profesorToProfesorDto(profesor);
        
        return profesorDtoCreado;
    }
    

    public ProfesorDto getProfesorDtoById(Long id) {
        Profesor profesor= this.profesorRepository.findById(id).orElseThrow(()-> new ProfesorNotFoundException(id));
        
        ProfesorDto profesorDto =  profesorMapper.profesorToProfesorDto(profesor);
        
        return profesorDto;
    }

    public List<ProfesorDto> getAllProfesorDto(){
        List<Profesor> profesores =this.profesorRepository.findAll();
        
        List<ProfesorDto> profesoresDto = profesorMapper.manyProfesorToProfesorDto(profesores);
        
        return profesoresDto;
    }

    public List<CursoDto> getAllCursosProfesor(Long idProfesor){
        Profesor profesorById = this.profesorRepository.findById(idProfesor).get();
        
        List<CursoDto> cursosProfesorById= cursoMapper.manyProfesorEnCursoToCursoDto(profesorById.getProfesorEnCurso()); 
        
        return cursosProfesorById;
    }


    public void deleteProfesorById(Long idProfesor){
        if(this.profesorRepository.existsById(idProfesor)){
            this.profesorRepository.deleteById(idProfesor);
        }else{
            throw new ProfesorNotFoundException(idProfesor);
        }
        
    }


    public boolean existsProfesorById(Long idProfesor) {
        return this.profesorRepository.existsById(idProfesor);
    }
}
