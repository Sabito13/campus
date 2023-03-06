package com.campusVirtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.dto.AlumnoDto;
import com.campusVirtual.dto.CursoDto;
import com.campusVirtual.service.AlumnoService;



@RestController
@RequestMapping(path="v1/alumno")
public class AlumnoController {

    private AlumnoService alumnoService;

    @Autowired
    public AlumnoController(AlumnoService alumnoService){
        this.alumnoService=alumnoService;
    }
    
    
    @GetMapping(path="/id/{id}")
    public AlumnoDto getAlumnoDtoById(@PathVariable("id") Long id){
        return this.alumnoService.getAlumnoDtoById(id);
    }

    @GetMapping(path="/todos")
    public List<AlumnoDto> getAllAlumnoDto(){
        return this.alumnoService.getAllAlumnoDto();
    }

    @GetMapping(path="cursos/alumno/{id}")
    public List<CursoDto> getAllCursosAlumno(@PathVariable("id") Long id){
        return this.alumnoService.getAllCursosAlumno(id);
    }
    

    @PostMapping(path="/nuevo")
    public AlumnoDto nuevoAlumno(@RequestBody AlumnoDto alumnoDto){
        return this.alumnoService.saveAlumnoDto(alumnoDto);
    }

    @DeleteMapping(path="/eliminar/{id}")
    public void deleteAlumno(@PathVariable("id") Long id){
        this.alumnoService.deleteAlumnoById(id);
    }


}
