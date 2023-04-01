package com.campusVirtual.service;

import com.campusVirtual.dto.CourseContentDto;
import java.util.List;

public interface ICourseContentService {
    public void addCourseContentWithVerifier(Long idCourse,CourseContentDto ccDto);
    public void addCourseContentWithoutVerifier(Long idCourse,CourseContentDto ccDto);

    public List<CourseContentDto> getAllCourseContentDtoForProfessor(Long idCourse);
    public List<CourseContentDto> getAllCourseContentDtoForStudent(Long idCourse);
    public void updateCourseContent(Long idCourse,CourseContentDto ccDto);
    public void deleteCourseContent(Long courseId,Long contentId);

    public void professorHaveAccessVerifier(Long courseId);
    public void studentHaveAccessVerifier(Long courseId);
}
