package com.campusVirtual.service;

import java.util.List;

import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.model.Course;

public interface ICourseService {
    
    
    public Course saveCourse(Course course);
    public Course getCourseById(Long idCoursed);
    public List<Course> getAllCourses();
    public void deleteCourseById(Long idCourse);
    public boolean existsCourseById(Long idCourse);
    public List<CourseDto> getAllCoursesOfProfessor(String username);
    public List<CourseDto> getAllCoursesOfStudent(String username);
     
    public CourseDto getCourseDtoById(Long id);
    public List<CourseDto> getAllCoursesDtos();
    public CourseDto saveCourseDto(CourseDto courseDto);

}
