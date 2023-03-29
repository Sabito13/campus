package com.campusVirtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusVirtual.dto.ProfessorDto;
import com.campusVirtual.exception.ErrorDetails;
import com.campusVirtual.service.IProfessorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping(path="v1/professor")
public class ProfessorController {

    @Autowired
    private IProfessorService professorService;


    @Operation(summary = "Get a Professor by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the professor",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ProfessorDto.class))}),
        @ApiResponse(responseCode = "404", description = "Professor not found",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorDetails.class))})
                        })
    @GetMapping(path = "/{id}")
    public ResponseEntity<ProfessorDto> getProfessorDtoById(
        @PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(professorService.getProfessorDtoById(id));
    }


    @Operation(summary = "Get a Professor by security context")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the professor",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProfessorDto.class)) }),
                })
    @GetMapping(path = "/me")
    @PreAuthorize("hasRole('ROLE_PROFESSOR')")
    public ResponseEntity<ProfessorDto> getProfessorDtoByContext(){
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok()
        .body(professorService.getProfessorDtoByUsername(username));
    }


    @Operation(summary = "Get all professor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all professorDtos",
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
            @ApiResponse(responseCode = "202", description = "All Professors of one course",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProfessorDto.class)) }),
    })
    @GetMapping(path ="/course/{id}")
    public ResponseEntity<List<ProfessorDto>> getAllProfessorsOfCourse(
        @PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(this.professorService.getAllProfessorsOfCourse(id));
    }


    

    @Operation(summary = "Delete professor by Professor id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Delete the professor",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProfessorDto.class)) }),
        @ApiResponse(responseCode = "404", description = "Professor not found",
                            content = { @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorDetails.class))})
})
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteProfessorById(@PathVariable("id") Long id){
        this.professorService.deleteProfessorById(id);
        return ResponseEntity.noContent().build();
    }

    
}
