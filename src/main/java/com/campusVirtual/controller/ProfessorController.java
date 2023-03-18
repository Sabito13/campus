package com.campusVirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.dto.ProfessorDto;
import com.campusVirtual.service.IProfessorService;

import java.util.List;

@RestController
@RequestMapping(path="v1/professor")
public class ProfessorController {

    @Autowired
    private IProfessorService professorService;

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ProfessorDto> getProfessorDtoById(
        @PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(professorService.getProfessorDtoById(id));
    }


    @GetMapping(path = "/me")
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    public ResponseEntity<ProfessorDto> getProfessorDtoByContext(
        ){
        Long id= Long.parseLong(SecurityContextHolder.getContext().getAuthentication().getName());
        return ResponseEntity.ok()
        .body(professorService.getProfessorDtoByDocument(id));
    }

    @GetMapping(path = "/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<ProfessorDto>> getAllProfessorDto(){
        return ResponseEntity.ok()
        .body(this.professorService.getAllProfessorsDto());
    }


    @GetMapping(path ="/course/{id}")
    public ResponseEntity<List<ProfessorDto>> getAllProfessorsOfCourse(
        @PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(this.professorService.getAllProfessorsOfCourse(id));
    }

    @PostMapping(path ="/{document}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ProfessorDto> createProfessor(
        @RequestBody ProfessorDto profesorDto,
        @PathVariable("document") long document ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.professorService.saveProfessor(profesorDto,document));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteProfessorById(@PathVariable("id") Long id){
        this.professorService.deleteProfessorById(id);
        return ResponseEntity.noContent().build();
    }

    
}
