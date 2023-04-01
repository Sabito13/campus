package com.campusVirtual.controller;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import com.campusVirtual.dto.CourseContentDto;
import com.campusVirtual.service.ICourseContentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;


@RestController
@RequestMapping("v1/content/")
public class CourseContentController {

    @Autowired
    private ICourseContentService contentService;
    
    

    @Operation(summary = "Create Content for Course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Content created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseContentDto.class)) }),
  })
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    @PostMapping("/course/{id}")
    public ResponseEntity<?> addCourseContent(@PathVariable("id") Long id,@RequestBody CourseContentDto ccDto){
        this.contentService.addCourseContentWithVerifier(id, ccDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @Operation(summary = "Get Content of Course for professor by Course Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Content of Course",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseContentDto.class)) }),
  })
    @GetMapping(path="/course/{id}/professor")
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    public ResponseEntity<List<CourseContentDto>> getAllCourseContentDtoByIdForProfessor(@PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(this.contentService.getAllCourseContentDtoForProfessor(id));
    }

    @Operation(summary = "Get Content of Course for student by Course Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Content of Course",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseContentDto.class)) }),
  })
    @GetMapping(path="/course/{id}/student")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public ResponseEntity<List<CourseContentDto>> getAllCourseContentDtoByIdForStudent(@PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(this.contentService.getAllCourseContentDtoForStudent(id));
    }


    @Operation(summary = "Update Content of Course by Content id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Update Content",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseContentDto.class)) }),
    })
    @PutMapping(path="/course/{id}")
    public ResponseEntity<?>updateCourseContent(@RequestBody CourseContentDto ccDto,
    @PathVariable("id") Long idCourse){
        this.contentService.updateCourseContent(idCourse,ccDto);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Delete content of course by Course id and Content id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Content deleted",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseContentDto.class)) }),
  })
    @DeleteMapping(path="/course/{idCourse}/contetent{idContent}")
    public ResponseEntity<?>deleteCourseContent(
        @PathVariable("idCourse") Long idCourse,
        @PathVariable("idContent") Long idContent){
        this.contentService.deleteCourseContent(idCourse,idContent);
        return ResponseEntity.noContent().build();
    }
}
