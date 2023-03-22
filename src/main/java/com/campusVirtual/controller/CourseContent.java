package com.campusVirtual.controller;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.campusVirtual.dto.CourseContentDto;
import com.campusVirtual.service.ICourseContentService;


@RestController
@RequestMapping("v1/content/")
public class CourseContent {

    @Autowired
    private ICourseContentService contentService;
    
    
    @PostMapping("/course/{id}")
    public ResponseEntity<?> addCourseContent(@PathVariable("id") Long id,@RequestBody CourseContentDto ccDto){
        this.contentService.addCourseContent(id, ccDto);;
        return ResponseEntity.noContent().build();
    }


    @GetMapping(path="/course/{id}")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CourseContentDto>> getAllCourseContentDtoById(@PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(this.contentService.getAllCourseContent(id));
    }

    @PutMapping(path="")
    public ResponseEntity<?>updateCourseContent(@RequestBody CourseContentDto ccDto){
        this.contentService.updateCourseContent(ccDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path="/course/{idCourse}/contetent{idContent}")
    public ResponseEntity<?>updateCourseContent(
        @PathVariable("idCourse") Long idCourse,
        @PathVariable("idContent") Long idContent){
        this.contentService.deleteCourseContent(idCourse,idContent);
        return ResponseEntity.noContent().build();
    }
}
