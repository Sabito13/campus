package com.campusVirtual.service;

import com.campusVirtual.dto.CourseDto;


public interface IStudentInCourseService{
    public CourseDto setStudentInCourse(Long idStudent,Long idCourse);
        
    public void deleteStudentInCourse(Long idStudent,Long idCourse);

    public void deleteStudentInCourseByUsername(String username, Long idCourse);

    public CourseDto setStudentInCourseByUsername(String username, Long idCourse);
       
}