package com.campusVirtual.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.campusVirtual.dto.CursoDto;
import com.campusVirtual.service.CursoService;


@RestController
@RequestMapping(path="v1/curso")
public class CursoController {

    private CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService){
        this.cursoService=cursoService;
    }


    @GetMapping(path="/id/{id}")
    public CursoDto getCursoDtoById(@PathVariable("id") Long id){
        return this.cursoService.getCursoDtoById(id);
    }

    @GetMapping(path="/cursos")
    public List<CursoDto> getCursoDtoById(){
        return this.cursoService.getAllCursosDto();
    }
    
  

    @PostMapping(path="/nuevo")
    public CursoDto crearCursos(@RequestBody CursoDto cursoDto){
        return this.cursoService.saveCursoDto(cursoDto);
    }



    @DeleteMapping("/eliminar/{id}")
    public void eliminarCurso(@PathVariable("id") Long id){
        this.cursoService.deleteCursoById(id);
    }

}
