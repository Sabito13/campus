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

import com.campusVirtual.dto.CourseDto;
import com.campusVirtual.exception.ErrorDetails;
import com.campusVirtual.service.IStudentInCourseService;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping(path = "v1/method/")
public class StudentInCourseController {

        @Autowired
        private IStudentInCourseService studentInCourseService;

        @Operation(summary = "Add student to course")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "202", description = "Student added to Course", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = CourseDto.class)) }),
                        @ApiResponse(responseCode = "404", description = "Student or Course not found", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))
                        })
        })
        @PreAuthorize("hasRole('ROLE_ADMIN')")
        @PostMapping(path = "/student/{idStudent}/course/{idCourse}")
        public ResponseEntity<?> addStudentToCourse(
                        @PathVariable("idStudent") Long idStudent,
                        @PathVariable("idCourse") Long idCourse) {

                return ResponseEntity.status(HttpStatus.CREATED)
                                .body(this.studentInCourseService.setStudentInCourse(idStudent, idCourse));
        }

        @Operation(summary = "Add me student to course")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "202", description = "Student added to Course", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = CourseDto.class)) }),
                        @ApiResponse(responseCode = "404", description = "Course not found", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))
                        })
        })
        @PreAuthorize("hasRole('ROLE_STUDENT')")
        @PostMapping(path = "/student/course/{idCourse}")
        public ResponseEntity<CourseDto> addMeStudentToCourse(
                        @PathVariable("idCourse") Long idCourse) {
                String username = SecurityContextHolder.getContext().getAuthentication().getName();

                return ResponseEntity.status(HttpStatus.CREATED)
                                .body(this.studentInCourseService.setStudentInCourseByUsername(username, idCourse));
        }

        @Operation(summary = "Delete student of course by both id")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "202", description = "Student in course deleted", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = CourseDto.class)) }),
                                        @ApiResponse(responseCode = "404", description = "Student or Course not found", content = {
                                                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))
                                        }) 
        })
        @PreAuthorize("hasRole('ROLE_ADMIN')")
        @DeleteMapping(path = "/student/{idStudent}/course/{idCourse}")
        public ResponseEntity<?> desvincularAlumnoCurso(
                        @PathVariable("idStudent") Long idStudent,
                        @PathVariable("idCourse") Long idCourse) {

                this.studentInCourseService.deleteStudentInCourse(idStudent, idCourse);
                return ResponseEntity.noContent().build();
        }

        @Operation(summary = "Delete student of course by Context")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Delete Student", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = CourseDto.class)) }),
                        @ApiResponse(responseCode = "404", description = "Course not found", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))
                        })
        })
        @DeleteMapping(path = "/student/course/{idCourse}")
        @PreAuthorize("hasRole('ROLE_STUDENT')")
        public ResponseEntity<?> deleteMeFromCourse(
                        @PathVariable("idCourse") Long idCourse) {
                String username = SecurityContextHolder.getContext().getAuthentication().getName();

                this.studentInCourseService.deleteStudentInCourseByUsername(username, idCourse);
                return ResponseEntity.noContent().build();
        }

}
