package com.campusVirtual.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.campusVirtual.dto.CursoDto;
import com.campusVirtual.service.ICursoService;


@RestController
@RequestMapping(path="v1/courses")
public class CursoController {
    
    @Autowired
    private ICursoService cursoService;


    @GetMapping(path="/{id}")
    public ResponseEntity<CursoDto> getCursoDtoById(@PathVariable("id") Long id){
        return ResponseEntity.ok()
        .body(this.cursoService.getCursoDtoById(id));
    }

    @GetMapping(path="/all")
    public ResponseEntity<List<CursoDto>> getCursoDtoById(){
        return ResponseEntity.ok()
        .body(this.cursoService.getAllCursosDto());
    }
    
  

    @PostMapping
    public ResponseEntity<CursoDto> crearCursos(@RequestBody CursoDto cursoDto){
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(this.cursoService.saveCursoDto(cursoDto));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCurso(@PathVariable("id") Long id){
        this.cursoService.deleteCursoById(id);
        return ResponseEntity.noContent().build();
    }

}
