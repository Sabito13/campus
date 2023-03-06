package com.campusVirtual.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.campusVirtual.dto.AlumnoEnCursoDto;
import com.campusVirtual.dto.ProfesorEnCursoDto;
import com.campusVirtual.service.AlumnoEnCursoService;
import com.campusVirtual.service.ProfesorEnCursoService;



@RestController
@RequestMapping(path="v1/admin")
public class AdminController {

    private ProfesorEnCursoService profesorEnCursoService;
    private AlumnoEnCursoService alumnoEnCursoService;

    @Autowired
    public AdminController(
        ProfesorEnCursoService profesorEnCursoService,
        AlumnoEnCursoService alumnoEnCursoService){
            this.profesorEnCursoService=profesorEnCursoService;
            this.alumnoEnCursoService=alumnoEnCursoService;
    }
    @GetMapping("/pec")
    public List<ProfesorEnCursoDto> profesoresCursos(){
        return this.profesorEnCursoService.getAllPecDto();
    }


    @GetMapping("/aec")
    public List<AlumnoEnCursoDto> alumnosCurso(){
        return this.alumnoEnCursoService.getAllAecDto();
    }

    @PostMapping(path ="/profesor/{idProfesor}/curso/{idCurso}")
    public ProfesorEnCursoDto asignarProfesorCurso(
        @PathVariable("idProfesor") Long idProfesor,
        @PathVariable("idCurso") Long idCurso){
            
            return  this.profesorEnCursoService.asignarProfesorCurso(idProfesor,idCurso);
    }



    
    @PostMapping(path ="/alumno/{idAlumno}/curso/{idCurso}")
    public AlumnoEnCursoDto asignarAlumnoCurso(
        @PathVariable("idAlumno") Long idAlumno,
        @PathVariable("idCurso") Long idCurso){
            
            return  this.alumnoEnCursoService.asignarAlumnoCurso(idAlumno,idCurso);
    }

   

    


   
        
    

   



}
