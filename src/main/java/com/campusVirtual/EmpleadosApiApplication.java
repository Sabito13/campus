package com.campusVirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.campusVirtual.model.Curso;
import com.campusVirtual.model.ProfesorEnCurso;
import com.campusVirtual.model.Profesor;
import com.campusVirtual.service.CursoService;
import com.campusVirtual.service.ProfesorEnCursoService;
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
			ProfesorEnCursoService profesorEnCursoService){
	return args -> {
	Profesor proIngles=profesorService.guardarProfesorBd(new Profesor("matias","ingles"));
	//Profesor proIngles2=profesorService.guardarProfesorBd(new Profesor("matia22s","ingles"));
	Profesor proMate=profesorService.guardarProfesorBd(new Profesor("pablo","matematica"));
	Profesor proRedes=profesorService.guardarProfesorBd(new Profesor("Juan","redes"));
	
	
	Curso redes=cursoService.crearCurso(new Curso("redes"));
	Curso ingles=cursoService.crearCurso(new Curso("ingles"));
	Curso ingles2=cursoService.crearCurso(new Curso("ingles avanzado"));
	Curso ingles3=cursoService.crearCurso(new Curso("ingles medio"));
	
	

	ProfesorEnCurso enseniaRedes = profesorEnCursoService.asignarProfesorCurso(proRedes, redes);
	proRedes.addEnsenia(enseniaRedes);
	redes.addEnsenia(enseniaRedes);
	profesorService.guardarProfesorBd(proRedes);
	cursoService.crearCurso(redes);
	
	ProfesorEnCurso enseniaIngles = profesorEnCursoService.asignarProfesorCurso(proIngles, ingles);
	proIngles.addEnsenia(enseniaIngles);
	ingles.addEnsenia(enseniaIngles);
	profesorService.guardarProfesorBd(proIngles);
	cursoService.crearCurso(ingles);


	ProfesorEnCurso enseniaIngles2 = profesorEnCursoService.asignarProfesorCurso(proIngles, ingles2);
	proIngles.addEnsenia(enseniaIngles2);
	ingles2.addEnsenia(enseniaIngles2);
	profesorService.guardarProfesorBd(proIngles);
	cursoService.crearCurso(ingles2);

	ProfesorEnCurso enseniaIngles3 = profesorEnCursoService.asignarProfesorCurso(proIngles, ingles3);
	proIngles.addEnsenia(enseniaIngles3);
	ingles3.addEnsenia(enseniaIngles3);
	profesorService.guardarProfesorBd(proIngles);
	cursoService.crearCurso(ingles3);
	
	System.out.println(proIngles.getProfesorEnCurso());	
		};
	
	}

}
