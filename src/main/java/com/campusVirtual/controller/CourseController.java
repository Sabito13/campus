package com.campusVirtual.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.exception.ErrorDetails;
import com.campusVirtual.service.ICourseService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
@RequestMapping(path="v1/course")
public class CourseController {
    
    @Autowired
    private ICourseService courseService;


    @Operation(summary = "Get Course by Course id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Course Found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseDto.class)) }),
            @ApiResponse(responseCode = "404", description = "Course not Found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDetails.class)) })
    })
    @GetMapping(path="/{id}")
    public ResponseEntity<CourseDto> getCourseDtoById(@PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(this.courseService.getCourseDtoById(id));
    }


    @Operation(summary = "Get all Courses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Courses Found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseDto.class)) })
    })
    @GetMapping(path="/all")
    public ResponseEntity<List<CourseDto>> getAllCourseDtoById(){
        return ResponseEntity.ok()
        .body(this.courseService.getAllCoursesDtos());
    }



    @Operation(summary = "Get all Courses Of Student by Security Contenxt")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Courses Found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseDto.class))}),
            @ApiResponse(responseCode = "404", description = "Courses not Found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseDto.class)) })
    })
    @GetMapping(path="/student/courses")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public ResponseEntity<List<CourseDto>> getAllCoursesOfStudent(){
        
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        
        return ResponseEntity.ok()
        .body(this.courseService.getAllCoursesOfStudent(username));
    }



   
    @Operation(summary = "Get all Courses Of Professor by Security Context")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Courses Found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseDto.class))}),
            @ApiResponse(responseCode = "404", description = "Courses not Found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseDto.class)) })
    })
    @GetMapping(path="/professor/courses")
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    public ResponseEntity<List<CourseDto>> getAllCoursesOfProfessor(){

        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        
        return ResponseEntity.ok()
        .body(this.courseService.getAllCoursesOfProfessor(username));
    }

   
    
  
    @Operation(summary = "Create Course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Course Created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseDto.class)) }),
    })
    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto cursoDto){
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(this.courseService.saveCourseDto(cursoDto));
    }



    @Operation(summary = "Delete Course by Course id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Delete the Course",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseDto.class)) }),
        @ApiResponse(responseCode = "404", description = "Course not found",
                            content = { @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorDetails.class))})
        })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("id") Long id){
        this.courseService.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }
 
}
