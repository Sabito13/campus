package com.campusVirtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusVirtual.dto.CursoDto;
import com.campusVirtual.service.CursoService;

@RestController
@RequestMapping(path="v1/admin")
public class AdminController {

    private CursoService cursoService;

    @Autowired
    public AdminController(CursoService cursoService){
        this.cursoService=cursoService;
    }

    
    @GetMapping(path="/cursos")
    public List<CursoDto> verCursos(){
        return this.cursoService.obtenerTodosLosCursos();
    }

    @PostMapping(path="/cursos")
    public String crearCursos(@RequestBody CursoDto cursoDto){
        this.cursoService.crearCurso(cursoDto);
        return "curso creado";
    }



}
