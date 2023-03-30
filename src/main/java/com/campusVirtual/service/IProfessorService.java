package com.campusVirtual.service;

import java.util.List;

import com.campusVirtual.dto.ProfessorDto;
import com.campusVirtual.model.Professor;

public interface IProfessorService {
    public ProfessorDto saveProfessor(String username);

    public Professor getProfessorById(Long idProfessor);

    public ProfessorDto getProfessorDtoById(Long idProfessor);
    
    public ProfessorDto getProfessorDtoByUsername(String username);

    public List<Professor> getAllProfessors();

    public List<ProfessorDto> getAllProfessorsDto();
    
    public List<ProfessorDto> getAllProfessorsOfCourse(Long idCourse);

    public boolean existProfessorById(Long idProfessor);
    
    public void deleteProfessorById(Long idProfessor);
   
}
