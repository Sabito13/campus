package com.campusVirtual.service.implementation;

import com.campusVirtual.service.ICourseContentService;
import com.campusVirtual.service.ICourseService;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.campusVirtual.dto.CourseContentDto;
import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.exception.ObjectNotFoundException;
import com.campusVirtual.exception.PermissionDeniedException;
import com.campusVirtual.mapper.CourseContentMapper;
import com.campusVirtual.model.Course;
import com.campusVirtual.model.CourseContent;
import com.campusVirtual.repository.CourseContentRepository;

@Service
public class CourseContentService implements ICourseContentService {
    
    private CourseContentMapper courseContentMapper = new CourseContentMapper();

    @Autowired
    private CourseContentRepository cContentRepository;
    
    @Autowired
    private ICourseService courseService;



    @Override
    public List<CourseContentDto> getAllCourseContentDtoForProfessor(Long idCourse) {
        
        this.professorHaveAccessVerifier(idCourse);

        List<CourseContent> cContent = this.courseService.getCourseById(idCourse).getCourseContent();
        return this.courseContentMapper.manyCourseContentToDto(cContent);
    }

    @Override
    public List<CourseContentDto> getAllCourseContentDtoForStudent(Long idCourse) {

        this.studentHaveAccessVerifier(idCourse);

        List<CourseContent> cContent = this.courseService.getCourseById(idCourse).getCourseContent();
        return this.courseContentMapper.manyCourseContentToDto(cContent);
    }


    @Override
    public void addCourseContentWithVerifier(Long idCourse,CourseContentDto ccDto) {

        this.professorHaveAccessVerifier(idCourse);

        CourseContent cContent = new CourseContent();
        cContent.setContent(ccDto.getContent());
        cContent.setTitle(ccDto.getTitle());
        cContent.setCourse(this.courseService.getCourseById(idCourse));

        cContent.setUtilDate(new Date());

        this.cContentRepository.save(cContent);
    }


    @Override
    public void addCourseContentWithoutVerifier(Long idCourse, CourseContentDto ccDto) {
        
        CourseContent newCourseContent = new CourseContent();
        
        newCourseContent.setContent(ccDto.getContent());
        newCourseContent.setTitle(ccDto.getTitle());
        newCourseContent.setCourse(this.courseService.getCourseById(idCourse));
        newCourseContent.setUtilDate(new Date());

        this.cContentRepository.save(newCourseContent);
    }


    @Override
    public void updateCourseContent(Long idCourse,CourseContentDto ccDto) {

        this.professorHaveAccessVerifier(idCourse);

        CourseContent cContent = this.cContentRepository.findById(ccDto.getId()).orElseThrow(()->new ObjectNotFoundException("Course content",ccDto.getId()));
        cContent.setContent(ccDto.getContent());
        cContent.setTitle(ccDto.getTitle());
        this.cContentRepository.save(cContent);
    }


    @Override
    public void deleteCourseContent(Long courseId,Long contentId) {

        this.professorHaveAccessVerifier(courseId);

        if(this.cContentRepository.existsById(contentId)){
            Course course =this.courseService.getCourseById(courseId);
            course.removeContentOfCourse(this.cContentRepository.findById(contentId).get());
            this.cContentRepository.deleteById(contentId);
        }else{
            throw new RuntimeException("Content not found");
        }
    }


    @Override
    public void professorHaveAccessVerifier(Long courseId) throws RuntimeException{
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
       
        List<CourseDto> allCourseOfProfessor = this.courseService.getAllCoursesOfProfessor(username);
         
        List<CourseDto> courseOfProfessor = allCourseOfProfessor
        .stream()
        .filter(c -> c.getId() == courseId)
        .collect(Collectors.toList());

        if (courseOfProfessor.isEmpty()) {
            throw new PermissionDeniedException("Professor does not have access to this course");
        }
    }


    @Override
    public void studentHaveAccessVerifier(Long courseId) throws RuntimeException{
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        
        List<CourseDto> allCourseOfStudent = this.courseService.getAllCoursesOfStudent(username);
         
        List<CourseDto> courseOfStudent = allCourseOfStudent
        .stream()
        .filter(c -> c.getId() == courseId)
        .collect(Collectors.toList());

        if (courseOfStudent.isEmpty()) {
            throw new PermissionDeniedException("Student does not have access to this course");
        }
    }

   
   
    
}
