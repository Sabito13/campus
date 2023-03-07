package com.campusVirtual.controller;




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
  

    @PostMapping(path ="/asignar/profesor/{idProfesor}/curso/{idCurso}")
    public ProfesorEnCursoDto asignarProfesorCurso(
        @PathVariable("idProfesor") Long idProfesor,
        @PathVariable("idCurso") Long idCurso){
            
            return  this.profesorEnCursoService.asignarProfesorCurso(idProfesor,idCurso);
    }

    @DeleteMapping(path ="/desvincular/profesor/{idProfesor}/curso/{idCurso}")
    public void desvincularProfesorCurso(
        @PathVariable("idProfesor") Long idProfesor,
        @PathVariable("idCurso") Long idCurso){
            
            this.profesorEnCursoService.desvincularProfesorCurso(idProfesor,idCurso);
    }



    
    @PostMapping(path ="asingnar/alumno/{idAlumno}/curso/{idCurso}")
    public AlumnoEnCursoDto asignarAlumnoCurso(
        @PathVariable("idAlumno") Long idAlumno,
        @PathVariable("idCurso") Long idCurso){
            
            return  this.alumnoEnCursoService.asignarAlumnoCurso(idAlumno,idCurso);
    }

    @DeleteMapping(path ="/desvincular/alumno/{idAlumno}/curso/{idCurso}")
    public void desvincularAlumnoCurso(
        @PathVariable("idAlumno") Long idAlumno,
        @PathVariable("idCurso") Long idCurso){
            
            this.alumnoEnCursoService.desvincularProfesorCurso(idAlumno,idCurso);
    }
   

    


   
        
    

   



}
