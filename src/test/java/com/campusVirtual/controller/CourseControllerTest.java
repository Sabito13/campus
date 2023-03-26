package com.campusVirtual.controller;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;



import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.repository.CourseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest 
@TestPropertySource(
        locations = "classpath:application-integ.properties"
)
//@WebMvcTest(controllers = CourseController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    
    //@Mock
    @Autowired
    private CourseRepository  courseRepository;

    



    @Autowired
    private ObjectMapper objectMapper;

/* 
    @Test
    void testSaveCourse() throws Exception{
        //given
        

        CourseDto courseDto = new CourseDto();
        courseDto.setName("Course Test");


        given(courseService.saveCourse(ArgumentMatchers.any()))
        .willAnswer(invocation -> invocation.getArgument(0));

        //when

        ResultActions response = mockMvc.perform(
        post("/v1/course")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(courseDto)));

        //then

        response.andExpect(MockMvcResultMatchers.status().isCreated());
    }


*/
    @Test
    void deleteCourse() throws Exception{
        //given
        CourseDto courseDto = new CourseDto();
        courseDto.setName("Course Test");


        mockMvc.perform(post("/v1/course")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(courseDto))
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isCreated());

                
                
                

        //boolean exists = courseRepository.existsCourseById((long)1);
        boolean exists = courseRepository.existsById((long)1);
        assertThat(exists).isTrue();

        // when
        ResultActions resultActions = mockMvc
                .perform(delete("/v1/course/"+1));

        // then
        resultActions.andExpect(status().isNoContent());
        //exists = courseService.existsCourseById((long)1);
        //assertThat(exists).isFalse();
    }
}
