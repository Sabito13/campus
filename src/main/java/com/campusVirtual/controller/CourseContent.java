package com.campusVirtual.controller;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.campusVirtual.dto.CourseContentDto;
import com.campusVirtual.service.ICourseContentService;


@RestController
@RequestMapping("v1/content/course")
public class CourseContent {

    @Autowired
    private ICourseContentService contentService;
    
    
    @PostMapping("/{id}/content")
    public ResponseEntity<?> addCourseContent(@PathVariable("id") Long id,@RequestBody CourseContentDto ccDto){
        this.contentService.addCourseContent(id, ccDto.getContent());;
        return ResponseEntity.noContent().build();
    }


    @GetMapping(path="/{id}/content")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CourseContentDto>> getAllCourseContentDtoById(@PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(this.contentService.getAllCourseContent(id));
    }
}
