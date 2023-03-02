package com.campusVirtual.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.campusVirtual.dto.CursoDto;
import com.campusVirtual.service.CursoService;


@RestController
@RequestMapping(path="v1/api/curso")
public class CursoController {

    private CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService){
        this.cursoService=cursoService;
    }



    
    @GetMapping(path="/cursos")
    public List<CursoDto> verCursos(){
        return this.cursoService.getAllCursosDto();
    }

    @PostMapping(path="/nuevo")
    public String crearCursos(@RequestBody CursoDto cursoDto){
        this.cursoService.saveCursoDto(cursoDto);
        return "curso creado";
    }
}
