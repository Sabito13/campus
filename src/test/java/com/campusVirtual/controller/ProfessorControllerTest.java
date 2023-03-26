package com.campusVirtual.controller;

import static org.mockito.Mockito.when;

import static org.mockito.BDDMockito.given;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import com.campusVirtual.dto.ProfessorDto;
import com.campusVirtual.service.implementation.ProfessorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




//@SpringBootTest 
@WebMvcTest(controllers = ProfessorController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class ProfessorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfessorService  professorService;


   

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void testSaveProfessor() throws Exception{
        ProfessorDto pDto = new ProfessorDto();
        pDto.setEspeciality("medicine");
        



        //response
        ProfessorDto pDtoWithId = new ProfessorDto();
        pDtoWithId.setEspeciality("medicine");
        pDtoWithId.setName("John");
        pDtoWithId.setId((long)1);

        // given
        //when(professorService.saveProfessor(pDto, "john"))
        //        .thenReturn(pDtoWithId);

        given(professorService.saveProfessor(pDto, "john"))
                .willReturn(pDtoWithId);
        

        // when
        MockHttpServletResponse response = mockMvc.perform(
                post("/v1/professor/john")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pDto))
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                        .andExpect(status().isCreated())
                        .andReturn().getResponse();
        // then

     
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        
        assertThat(response.getContentAsString()).isEmpty();
        
        //assertThat(response.getContentAsString()).isEqualTo(
        //        objectMapper.writeValueAsString(pDtoWithId));


    }



    @Test
    void testGetProfessor() throws Exception{
     

        //response
        ProfessorDto pDtoWithId = new ProfessorDto();
        pDtoWithId.setEspeciality("medicine");
        pDtoWithId.setName("John");
        pDtoWithId.setId((long)1);

        // given
        when(professorService.getProfessorDtoById((long)1))
                .thenReturn(pDtoWithId);

        // when
        MockHttpServletResponse response = mockMvc.perform(
                get("/v1/professor/"+1)
                        .accept(MediaType.APPLICATION_JSON))
                        .andReturn()
                        .getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        
        assertThat(response.getContentAsString()).isNotEmpty();
        
        assertThat(response.getContentAsString()).isEqualTo(
                objectMapper.writeValueAsString(pDtoWithId));


    }

}