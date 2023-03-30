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
    public List<CourseContentDto> getAllCourseContent(Long idCourse) {
        List<CourseContent> cContent = this.courseService.getCourseById(idCourse).getCourseContent();
        return this.courseContentMapper.manyCourseContentToDto(cContent);
    }


    @Override
    public void addCourseContent(Long idCourse,CourseContentDto ccDto) {

        this.professorHaveAccessVerifier(idCourse);


        CourseContent cContent = new CourseContent();
        cContent.setContent(ccDto.getContent());
        cContent.setCourse(this.courseService.getCourseById(idCourse));

        cContent.setUtilDate(new Date());

        this.cContentRepository.save(cContent);
    }


    @Override
    public void updateCourseContent(Long idCourse,CourseContentDto ccDto) {

        this.professorHaveAccessVerifier(idCourse);


        CourseContent cContent = this.cContentRepository.findById(ccDto.getId()).get();
        cContent.setContent(ccDto.getContent());
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
            throw new RuntimeException("Professor does not have acces to this course");
        }
    }
   
    
}
