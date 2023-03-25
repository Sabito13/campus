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


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;


@RestController
@RequestMapping(path="v1/professor")
public class ProfessorController {

    @Autowired
    private IProfessorService professorService;


    @Operation(summary = "Get Professor by Professor id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Update Activity",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProfessorDto.class)) }),
  })
    @GetMapping(path = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ProfessorDto> getProfessorDtoById(
        @PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(professorService.getProfessorDtoById(id));
    }

    @Operation(summary = "Get mi Professor by security context")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Update Activity",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProfessorDto.class)) }),
  })
    @GetMapping(path = "/me")
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    public ResponseEntity<ProfessorDto> getProfessorDtoByContext(
        ){
                String username= SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok()
        .body(professorService.getProfessorDtoByUsername(username));
    }


    @Operation(summary = "Get all professor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Update Activity",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProfessorDto.class)) }),
  })
    @GetMapping(path = "/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<ProfessorDto>> getAllProfessorDto(){
        return ResponseEntity.ok()
        .body(this.professorService.getAllProfessorsDto());
    }






    @Operation(summary = "Get all Professors of one course by course id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Update Activity",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProfessorDto.class)) }),
  })
    @GetMapping(path ="/course/{id}")
    public ResponseEntity<List<ProfessorDto>> getAllProfessorsOfCourse(
        @PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(this.professorService.getAllProfessorsOfCourse(id));
    }


    @Operation(summary = "Asign role and Professor functions to a one user by user document")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Update Activity",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProfessorDto.class)) }),
  })
    @PostMapping(path ="/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ProfessorDto> createProfessor(
        @RequestBody ProfessorDto profesorDto,
        @PathVariable("username") String username ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.professorService.saveProfessor(profesorDto,username));
    }




    @Operation(summary = "Delete professor by Professor id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Update Activity",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProfessorDto.class)) }),
  })
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteProfessorById(@PathVariable("id") Long id){
        this.professorService.deleteProfessorById(id);
        return ResponseEntity.noContent().build();
    }

    
}
