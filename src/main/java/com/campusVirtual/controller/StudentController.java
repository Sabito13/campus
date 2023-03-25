package com.campusVirtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.dto.StudentDto;
import com.campusVirtual.service.IStudentService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;




@RestController
@RequestMapping(path="v1/student")
public class StudentController { 
    
    @Autowired
    private IStudentService studentService;
    


    @Operation(summary = "Get Student by Student id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Update Activity",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudentDto.class)) }),
  })
    @GetMapping(path="/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public  ResponseEntity<StudentDto> getStudenById(@PathVariable("id") Long id){
        return  ResponseEntity.ok()
                .body(this.studentService.getStudentDtoById(id));
    }


    @Operation(summary = "Get mi Student by security context")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Update Activity",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudentDto.class)) }),
  })
    @GetMapping(path="/me")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public ResponseEntity<StudentDto> getStudentDtoByContex(){
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username);
        System.out.println("");
        System.out.println("");

        return  ResponseEntity.ok()
               .body(this.studentService.getStudentDtoByUsername(username));
    }


    @Operation(summary = "Get all students")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Update Activity",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudentDto.class)) }),
  })
    @GetMapping(path="/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<StudentDto>> getAllAlumnoDto(){
        return ResponseEntity.ok()
                .body(this.studentService.getAllStudentsDto());
    }




    @Operation(summary = "Get all student of one course by course id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Update Activity",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudentDto.class)) }),
  })
    @GetMapping(path ="/course/{id}")
    public ResponseEntity<List<StudentDto>> getAllStudentsOfCourse(
        @PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(this.studentService.getAllStudentsOfCourse(id));
    }

  
    



    @Operation(summary = "Asign role and student functions to a one user by user document")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Update Activity",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudentDto.class)) }),
  })
    @PostMapping(path="/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<StudentDto> createStudent(
        @RequestBody StudentDto studentDto,
        @PathVariable("username") String username){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.studentService.saveStudent(username));
    }

    




    @Operation(summary = "delete student by student id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Update Activity",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudentDto.class)) }),
  })
    @DeleteMapping(path="/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteAlumno(@PathVariable("id") Long id){
        this.studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

   
}
