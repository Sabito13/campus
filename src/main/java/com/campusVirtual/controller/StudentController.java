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



@RestController
@RequestMapping(path="v1/student")
public class StudentController { 
    
    @Autowired
    private IStudentService studentService;
    
    
    @GetMapping(path="/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public  ResponseEntity<StudentDto> getStudenById(@PathVariable("id") Long id){
        return  ResponseEntity.ok()
                .body(this.studentService.getStudentDtoById(id));
    }

    @GetMapping(path="/me")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public ResponseEntity<StudentDto> getStudentDtoByContex(){
        Long document= Long.parseLong(SecurityContextHolder.getContext().getAuthentication().getName());
        return  ResponseEntity.ok()
               .body(this.studentService.getStudentDtoByDocument(document));
    }



    @GetMapping(path="/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<StudentDto>> getAllAlumnoDto(){
        return ResponseEntity.ok()
                .body(this.studentService.getAllStudentsDto());
    }

    @GetMapping(path ="/course/{id}")
    public ResponseEntity<List<StudentDto>> getAllStudentsOfCourse(
        @PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(this.studentService.getAllStudentsOfCourse(id));
    }

  
    

    @PostMapping(path="/{document}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<StudentDto> createStudent(
        @RequestBody StudentDto studentDto,
        @PathVariable("document") Long document){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.studentService.saveStudent(document));
    }

    @DeleteMapping(path="/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteAlumno(@PathVariable("id") Long id){
        this.studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

   
}
