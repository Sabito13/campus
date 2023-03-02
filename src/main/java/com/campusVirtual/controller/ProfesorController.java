package com.campusVirtual.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="v2/profesor")
public class ProfesorController {
    @GetMapping
    public String getProfesores(){
       return "profesor 123";
    }

    @PostMapping("/nuevo")
    public void crearProfesor(){

    }


    @PostMapping(path = "asignarProfesor")
    public String asignarProfesorCurso(){
        return "profesor creado";
    }
    
}
