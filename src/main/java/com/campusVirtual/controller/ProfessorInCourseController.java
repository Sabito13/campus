package com.campusVirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.exception.ErrorDetails;
import com.campusVirtual.service.IProfessorInCourseService;

@RestController
@RequestMapping(path = "v1/method")
public class ProfessorInCourseController {

    @Autowired
    private IProfessorInCourseService professorInCourseService;

    @Operation(summary = "Delete professor of course by both id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Added professor to course", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CourseDto.class)) }),
            @ApiResponse(responseCode = "404", description = "Professor or Course not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))
            }) })
    @PostMapping(path = "/professor/{idProfessor}/course/{idCourse}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<CourseDto> addProfessorToCourse(
            @PathVariable("idProfessor") Long idProfessor,
            @PathVariable("idCourse") Long idCourse) {

        this.professorInCourseService.setProfessorInCourse(idProfessor, idCourse);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Add me Professor to course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Professor added to Course", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CourseDto.class)) }),
    })
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    @PostMapping(path = "/professor/course/{idCourse}")
    public ResponseEntity<CourseDto> addMeProfessorToCourse(
            @PathVariable("idCourse") Long idCourse) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.professorInCourseService.setProfessorInCourseByUsername(username, idCourse));
    }

    @Operation(summary = "Delete Professor of course by Context")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Professor In Course Deleted", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CourseDto.class)) }),
            @ApiResponse(responseCode = "404", description = "Course not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))
            })
    })
    @DeleteMapping(path = "/professor/course/{idCourse}")
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    public ResponseEntity<?> deleteMeFromCourse(
            @PathVariable("idCourse") Long idCourse) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        this.professorInCourseService.deleteProfessorInCourseByUsername(username, idCourse);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete professor of course by both id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete Student", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CourseDto.class)) }),
            @ApiResponse(responseCode = "404", description = "Professor or Course not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))
            }) })

    @DeleteMapping(path = "/professor/{idProfessor}/course/{idCourse}")
    public ResponseEntity<?> desvincularProfesorCurso(
            @PathVariable("idProfessor") Long idProfessor,
            @PathVariable("idCourse") Long idCourse) {

        this.professorInCourseService.deleteProfessorInCourse(idProfessor, idCourse);
        return ResponseEntity.noContent().build();
    }
}
