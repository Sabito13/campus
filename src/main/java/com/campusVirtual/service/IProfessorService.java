package com.campusVirtual.service;

import java.util.List;

import com.campusVirtual.dto.ProfessorDto;
import com.campusVirtual.model.Professor;

public interface IProfessorService {
    public void saveProfessor(Professor professor,Long document);

    public Professor getProfessorById(Long idProfessor);

    public List<Professor> getAllProfessors();
    
    public List<ProfessorDto> getAllProfessorsOfCourse(Long idCourse);

    public boolean existProfessorById(Long idProfessor);
    
    public void deleteProfessorById(Long idProfessor);
   
}
