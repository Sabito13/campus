package com.campusVirtual.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.campusVirtual.dto.CourseContentDto;
import com.campusVirtual.model.Course;
import com.campusVirtual.model.CourseContent;
import com.campusVirtual.repository.CourseContentRepository;
import com.campusVirtual.service.implementation.CourseContentService;
import com.campusVirtual.service.implementation.CourseService;

public class CourseContentServiceTest {
  @Mock
  private CourseContentRepository courseContentRepositoryTest;

  @Mock
  private CourseService courseServiceTest;

  @InjectMocks
  private CourseContentService courseContentServiceTest;

  private CourseContent cContentToTest;

  @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        this.cContentToTest = new CourseContent();
        this.cContentToTest.setContent("test content");
        this.cContentToTest.setTitle("test title");

    }

    @Test
    void createContent(){

      CourseContent cContentExpected = this.cContentToTest;
      cContentExpected.setId((long)1);


      when(this.courseContentRepositoryTest.save(any(CourseContent.class)))
      .thenReturn(cContentExpected);

      when(this.courseServiceTest.getCourseById((long)2))
      .thenReturn(new Course("course test"));


      this.courseContentServiceTest.addCourseContentWithoutVerifier((long)2, new CourseContentDto());

      
    }

}
