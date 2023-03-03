package com.campusVirtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.dto.ProfesorDto;
import com.campusVirtual.mapper.ProfesorMapper;
import com.campusVirtual.model.Profesor;
import com.campusVirtual.repository.ProfesorRepository;

@Service
public class ProfesorService {
    
    ProfesorRepository profesorRepository;
    ProfesorMapper profesorMapper = new ProfesorMapper();

    @Autowired
    public ProfesorService( ProfesorRepository profesorRepository){
        this.profesorRepository=profesorRepository;
    }

    
    public Profesor saveProfesorNoDto(Profesor profesor) {
        return this.profesorRepository.save(profesor);
    }

    public void saveProfesorDto(ProfesorDto profesorDto) {
        Profesor profesor = this.profesorMapper.profesorDtoToProfesor(profesorDto);
        this.profesorRepository.save(profesor);
    }
    

    public Profesor getProfesorNoDtoById(Long id) {
        return this.profesorRepository.findById(id).get();
    }

    public ProfesorDto getProfesorDtoById(Long id) {
        Profesor profesor= this.profesorRepository.findById(id).get();
        return profesorMapper.profesorToProfesorDto(profesor);
    }

    public List<ProfesorDto> getAllProfesorDto(){
        List<Profesor> profesores =this.profesorRepository.findAll();
        
        return profesorMapper.manyProfesorToProfesorDto(profesores);
    
    }


    public void deleteProfesorById(Long idProfesor){
        this.profesorRepository.deleteById(idProfesor);
    }
}
