package com.campusVirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.dto.ProfesorDto;
import com.campusVirtual.service.ProfesorService;

import java.util.List;

@RestController
@RequestMapping(path="v2/profesor")
public class ProfesorController {

    ProfesorService profesorService;

    @Autowired
    public ProfesorController(ProfesorService profesorService){
       this.profesorService=profesorService;
    }





    @PostMapping("/nuevo")
    public void crearProfesor(@RequestBody ProfesorDto profesorDto){
        this.profesorService.saveProfesorDto(profesorDto);;
    }


    @GetMapping(path = "/profesores")
    public List<ProfesorDto> asignarProfesorCurso(){
        return profesorService.getAllProfesorDto();
    }
    
}
