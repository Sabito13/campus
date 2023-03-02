package com.campusVirtual.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.dto.ProfesorEnCursoDto;
import com.campusVirtual.model.ProfesorEnCurso;
import com.campusVirtual.service.CursoService;
import com.campusVirtual.service.ProfesorEnCursoService;
import com.campusVirtual.service.ProfesorService;



@RestController
@RequestMapping(path="v1/admin")
public class AdminController {

    ProfesorEnCursoService profesorEnCursoService;

    @Autowired
    public AdminController(
        ProfesorEnCursoService profesorEnCursoService){
            this.profesorEnCursoService=profesorEnCursoService;
    }


    @PostMapping(path ="/profesor/{idProfesor}/curso/{idCurso}")
    public ProfesorEnCursoDto asignarProfesorCurso(
        @PathVariable("idProfesor") Long idProfesor,
        @PathVariable("idCurso") Long idCurso){
            
            return  this.profesorEnCursoService.asignarProfesorCurso(idProfesor,idCurso);
    }

    @GetMapping("/pec")
    public List<ProfesorEnCursoDto> crearAdmin(){
        return this.profesorEnCursoService.getAllPecDto();
    }

    


   
        
    

   



}
