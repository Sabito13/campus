package com.campusVirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.dto.CursoDto;
import com.campusVirtual.dto.ProfesorDto;
import com.campusVirtual.service.ProfesorService;

import java.util.List;

@RestController
@RequestMapping(path="v1/profesor")
public class ProfesorController {

    ProfesorService profesorService;

    @Autowired
    public ProfesorController(ProfesorService profesorService){
       this.profesorService=profesorService;
    }

    @GetMapping(path = "/id/{id}")
    public ProfesorDto getProfesorDtoById(
        @PathVariable("id") Long id){
        return profesorService.getProfesorDtoById(id);
    }

    @GetMapping(path = "/todos")
    public List<ProfesorDto> getAllProfesorDto(){
        return this.profesorService.getAllProfesorDto();
    }


    @GetMapping(path ="/cursos/profesor/{id}")
    public List<CursoDto> getAllCursosProfesor(
        @PathVariable("id") Long id){
        return this.profesorService.getAllCursosProfesor(id);
    }

    @PostMapping(path ="/nuevo")
    public ProfesorDto nuevoProfesor(
        @RequestBody ProfesorDto profesorDto){
        return this.profesorService.saveProfesorDto(profesorDto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteProfesorById(@PathVariable("id") Long id){
        this.profesorService.deleteProfesorById(id);
    }


}
