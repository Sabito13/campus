package com.campusVirtual.service;

import com.campusVirtual.dto.CourseContentDto;
import java.util.List;

public interface ICourseContentService {
    public void addCourseContent(Long idCourse,CourseContentDto ccDto);
    public List<CourseContentDto> getAllCourseContent(Long idCourse);
    public void updateCourseContent(CourseContentDto ccDto);
    public void deleteCourseContent(Long courseId,Long contentId);
}
