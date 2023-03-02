package com.campusVirtual.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusVirtual.dto.ProfesorEnCursoDto;
import com.campusVirtual.model.ProfesorEnCurso;
import com.campusVirtual.service.CursoService;
import com.campusVirtual.service.ProfesorEnCursoService;
import com.campusVirtual.service.ProfesorService;



@RestController
@RequestMapping(path="v1/admin")
public class AdminController {

    ProfesorService profesorService;
    CursoService cursoService;
    ProfesorEnCursoService profesorEnCursoService;

    @Autowired
    public AdminController(
        ProfesorService profesorService,
        CursoService cursoService,
        ProfesorEnCursoService profesorEnCursoService){
            this.profesorService=profesorService;
            this.cursoService=cursoService;
            this.profesorEnCursoService=profesorEnCursoService;
    }


    @PostMapping(path ="/profesor/{idProfesor}/curso/{idCurso}")
    public ProfesorEnCursoDto asignarProfesorCurso(
        @PathVariable("idProfesor") Long idProfesor,
        @PathVariable("idCurso") Long idCurso){
            
            return  this.profesorEnCursoService.asignarProfesorCurso(idProfesor,idCurso);
    }

    @PostMapping()
    public String crearAdmin(){
        return "ADMIN CREADO";
    }

    


   
        
    

   



}
