package com.campusVirtual.controller;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class CourseContent {

    @Autowired
    private ICourseContentService contentService;
    
    

    @Operation(summary = "Create Content for Course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Content created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseContentDto.class)) }),
  })
    @PostMapping("/course/{id}")
    public ResponseEntity<?> addCourseContent(@PathVariable("id") Long id,@RequestBody CourseContentDto ccDto){
        this.contentService.addCourseContent(id, ccDto);;
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Get Content of Course by Course Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Content of Course",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseContentDto.class)) }),
  })
    @GetMapping(path="/course/{id}")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CourseContentDto>> getAllCourseContentDtoById(@PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(this.contentService.getAllCourseContent(id));
    }


    @Operation(summary = "Update Content of Course by Content id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Update Content",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseContentDto.class)) }),
    })
    @PutMapping(path="")
    public ResponseEntity<?>updateCourseContent(@RequestBody CourseContentDto ccDto){
        this.contentService.updateCourseContent(ccDto);
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
