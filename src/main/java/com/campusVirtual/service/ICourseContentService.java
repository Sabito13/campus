package com.campusVirtual.service;

import com.campusVirtual.dto.CourseContentDto;
import java.util.List;

public interface ICourseContentService {
    public void addCourseContent(Long idCourse,String content);
    public List<CourseContentDto> getAllCourseContent(Long idCourse);

}
