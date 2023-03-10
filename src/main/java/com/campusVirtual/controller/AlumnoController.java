package com.campusVirtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.dto.AlumnoDto;
import com.campusVirtual.dto.CursoDto;
import com.campusVirtual.service.IAlumnoService;



@RestController
@RequestMapping(path="v1/alumno")
public class AlumnoController {

    private IAlumnoService alumnoService;

    @Autowired
    public AlumnoController(IAlumnoService alumnoService){
        this.alumnoService=alumnoService;
    }
    
    
    @GetMapping(path="/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public  ResponseEntity<AlumnoDto> getAlumnoDtoById(@PathVariable("id") Long id){
        return  ResponseEntity.ok()
                .body(this.alumnoService.getAlumnoDtoById(id));
    }

    @GetMapping(path="/todos")
    @PreAuthorize("hasRole('ROLE_ALUMNO')")
    public ResponseEntity<List<AlumnoDto>> getAllAlumnoDto(){
        return ResponseEntity.ok()
                .body(this.alumnoService.getAllAlumnoDto());
    }

    @GetMapping(path="/{id}/cursos")
    public ResponseEntity<List<CursoDto>> getAllCursosAlumno(@PathVariable("id") Long id){
        return ResponseEntity.ok()
                .body(this.alumnoService.getAllCursosAlumno(id));
    }
    

    @PostMapping(path="")
    public ResponseEntity<AlumnoDto> nuevoAlumno(@RequestBody AlumnoDto alumnoDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.alumnoService.saveAlumnoDto(alumnoDto));
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> deleteAlumno(@PathVariable("id") Long id){
        this.alumnoService.deleteAlumnoById(id);
        return ResponseEntity.noContent().build();
    }


}
