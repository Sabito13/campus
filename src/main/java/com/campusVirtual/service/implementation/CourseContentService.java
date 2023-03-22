package com.campusVirtual.service.implementation;

import com.campusVirtual.service.ICourseContentService;
import com.campusVirtual.service.ICourseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.dto.CourseContentDto;
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
        CourseContent cContent = new CourseContent();
        cContent.setContent(ccDto.getContent());
        cContent.setCourse(this.courseService.getCourseById(idCourse));

        this.cContentRepository.save(cContent);
    }


    @Override
    public void updateCourseContent(CourseContentDto ccDto) {
        CourseContent cContent = this.cContentRepository.findById(ccDto.getId()).get();
        cContent.setContent(ccDto.getContent());
        this.cContentRepository.save(cContent);
    }


    @Override
    public void deleteCourseContent(Long courseId,Long contentId) {
        if(this.cContentRepository.existsById(contentId)){
            Course course =this.courseService.getCourseById(courseId);
            course.removeContentOfCourse(this.cContentRepository.findById(contentId).get());
            this.cContentRepository.deleteById(contentId);
        }else{
            throw new RuntimeException("Content not found");
        }
    }
   
    
}
