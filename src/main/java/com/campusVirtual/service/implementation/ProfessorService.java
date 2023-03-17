package com.campusVirtual.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.dto.ProfessorDto;
import com.campusVirtual.exception.ProfessorNotFoundException;
import com.campusVirtual.mapper.ProfessorMapper;
import com.campusVirtual.model.Course;
import com.campusVirtual.model.Professor;
import com.campusVirtual.model.ProfessorInCourse;
import com.campusVirtual.repository.ProfessorRepository;
import com.campusVirtual.service.ICourseService;
import com.campusVirtual.service.IProfessorService;
import com.campusVirtual.service.IUserDataService;

@Service
public class ProfessorService implements IProfessorService{

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private IUserDataService userDataService; 

    @Autowired
    private ICourseService courseService;

    private ProfessorMapper pMapper = new ProfessorMapper();

    @Override
    public ProfessorDto saveProfessor(ProfessorDto professorDto, Long document) {
        Professor profesorSet = new Professor(professorDto.getEspeciality());

        profesorSet = this.professorRepository.save(profesorSet);

        profesorSet.setUser(this.userDataService.getUserById(document));
        
        profesorSet = this.professorRepository.save(profesorSet);

        return pMapper.professorToProfessorDto(profesorSet);
    }

    @Override
    public Professor getProfessorById(Long idProfessor) {
      return  this.professorRepository.findById(idProfessor).orElseThrow(()-> new ProfessorNotFoundException(idProfessor));
    }

    @Override
    public ProfessorDto getProfessorDtoById(Long idProfessor) {
      return pMapper.professorToProfessorDto(getProfessorById(idProfessor));
    }

    @Override
    public List<Professor> getAllProfessors() {
        return  this.professorRepository.findAll();  
    }

    @Override
    public List<ProfessorDto> getAllProfessorsDto() {
        return  pMapper.manyProfessorToProfessorDto(getAllProfessors());  
    }
    

    @Override
    public List<ProfessorDto> getAllProfessorsOfCourse(Long idCourse) {
        Course course = this.courseService.getCourseById(idCourse);

        List<ProfessorInCourse> professorsRelation=course.getProfessorInCourse();
        
        List<Professor> professors=new ArrayList<>();
        for (ProfessorInCourse professor : professorsRelation) {
            professors.add(professor.getProfessor());
        }
        return this.pMapper.manyProfessorToProfessorDto(professors);
    }

    @Override
    public boolean existProfessorById(Long idProfessor) {
      return this.professorRepository.existsById(idProfessor);
    }

    @Override
    public void deleteProfessorById(Long idProfessor) {
        if(this.professorRepository.existsById(idProfessor)){
            this.professorRepository.deleteById(idProfessor);
        }else{
            throw new ProfessorNotFoundException(idProfessor);
        }
    }
    
   
}
