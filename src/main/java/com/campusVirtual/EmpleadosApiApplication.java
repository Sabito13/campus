package com.campusVirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.campusVirtual.model.Curso;
import com.campusVirtual.model.Ensenia;
import com.campusVirtual.model.Profesor;
import com.campusVirtual.service.CursoService;
import com.campusVirtual.service.EnseniaService;
import com.campusVirtual.service.ProfesorService;

@SpringBootApplication
public class EmpleadosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpleadosApiApplication.class, args);
	}

	@Bean
    CommandLineRunner commandLineRunner(
            ProfesorService profesorService,
			CursoService cursoService,
			EnseniaService enseniaService){
	return args -> {
	Profesor proIngles=profesorService.guardarProfesorBd(new Profesor("matias","ingles"));
	Profesor proMate=profesorService.guardarProfesorBd(new Profesor("pablo","matematica"));
	Profesor proRedes=profesorService.guardarProfesorBd(new Profesor("Juan","redes"));
	
	
	Curso redes=cursoService.crearCurso(new Curso("redes"));
	Curso ingles=cursoService.crearCurso(new Curso("ingles"));
	
	

	Ensenia enseniaRedes = enseniaService.asignarProfesorCurso(proRedes, redes);
	proRedes.addEnsenia(enseniaRedes);
	redes.addEnsenia(enseniaRedes);
	profesorService.guardarProfesorBd(proRedes);
	cursoService.crearCurso(redes);
	
	Ensenia enseniaIngles = enseniaService.asignarProfesorCurso(proIngles, ingles);
	proIngles.addEnsenia(enseniaIngles);
	ingles.addEnsenia(enseniaIngles);
	profesorService.guardarProfesorBd(proIngles);
	cursoService.crearCurso(ingles);


		};
	
	}

}
