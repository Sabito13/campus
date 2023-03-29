package com.campusVirtual.service;

import com.campusVirtual.dto.CourseDto;

public interface IProfessorInCourseService {

    public CourseDto setProfessorInCourse(Long idProfessor,Long idCourse);

    public CourseDto setProfessorInCourseByUsername(String username, Long idCourse);
        
    public void deleteProfessorInCourse(Long idProfessor,Long idCourse);

    public void deleteProfessorInCourseByUsername(String username, Long idCourse);

  
       
        
}
