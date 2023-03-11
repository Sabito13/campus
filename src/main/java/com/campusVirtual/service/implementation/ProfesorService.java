package com.campusVirtual.service.implementation;

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
import com.campusVirtual.service.IProfesorService;

@Service
public class ProfesorService implements IProfesorService{
    
    @Autowired
    ProfesorRepository profesorRepository;
    ProfesorMapper profesorMapper = new ProfesorMapper();
    private CursoMapper cursoMapper = new CursoMapper();


    @Override
    public Profesor saveProfesorNoDto(Profesor profesor) {
        return this.profesorRepository.save(profesor);
    }
    
    @Override
    public Profesor getProfesorNoDtoById(Long id) {
        return this.profesorRepository.findById(id).orElseThrow(()-> new ProfesorNotFoundException(id));
    }
    
    @Override
    public ProfesorDto saveProfesorDto(ProfesorDto profesorDto) {
        Profesor profesor = this.profesorMapper.profesorDtoToProfesor(profesorDto);
        
        profesor = this.profesorRepository.save(profesor);

        ProfesorDto profesorDtoCreado = this.profesorMapper.profesorToProfesorDto(profesor);
        
        return profesorDtoCreado;
    }
    
    @Override
    public ProfesorDto getProfesorDtoById(Long id) {
        Profesor profesor= this.profesorRepository.findById(id).orElseThrow(()-> new ProfesorNotFoundException(id));
        
        ProfesorDto profesorDto =  profesorMapper.profesorToProfesorDto(profesor);
        
        return profesorDto;
    }

    @Override
    public List<ProfesorDto> getAllProfesorDto(){
        List<Profesor> profesores =this.profesorRepository.findAll();
        
        List<ProfesorDto> profesoresDto = profesorMapper.manyProfesorToProfesorDto(profesores);
        
        return profesoresDto;
    }

    @Override
    public List<CursoDto> getAllCursosProfesor(Long idProfesor){
        Profesor profesorById = this.profesorRepository.findById(idProfesor).get();
        
        List<CursoDto> cursosProfesorById= cursoMapper.manyProfesorEnCursoToCursoDto(profesorById.getProfesorEnCurso()); 
        
        return cursosProfesorById;
    }

    @Override
    public void deleteProfesorById(Long idProfesor){
        if(this.profesorRepository.existsById(idProfesor)){
            this.profesorRepository.deleteById(idProfesor);
        }else{
            throw new ProfesorNotFoundException(idProfesor);
        }
        
    }

    @Override
    public boolean existsProfesorById(Long idProfesor) {
        return this.profesorRepository.existsById(idProfesor);
    }
}
