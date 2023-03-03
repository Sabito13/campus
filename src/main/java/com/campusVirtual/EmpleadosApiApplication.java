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
	Profesor proIngles=profesorService.saveProfesorNoDto(new Profesor("matias","ingles"));
	Profesor proIngles2=profesorService.saveProfesorNoDto(new Profesor("matia22s","ingles"));
	profesorService.saveProfesorNoDto(new Profesor("pablo","matematica"));
	Profesor proRedes=profesorService.saveProfesorNoDto(new Profesor("Juan","redes"));
	
	
	Curso redes=cursoService.saveCursoNoDto(new Curso("redes"));
	Curso ingles=cursoService.saveCursoNoDto(new Curso("ingles"));
	Curso ingles2=cursoService.saveCursoNoDto(new Curso("ingles avanzado"));
	Curso ingles3=cursoService.saveCursoNoDto(new Curso("ingles medio"));
	
	

	ProfesorEnCurso enseniaRedes = profesorEnCursoService.asignarProfesorCurso(proRedes, redes);
	proRedes.addProfesorEnCurso(enseniaRedes);
	redes.addProfesorEnCurso(enseniaRedes);
	profesorService.saveProfesorNoDto(proRedes);
	cursoService.saveCursoNoDto(redes);
	
	ProfesorEnCurso enseniaIngles = profesorEnCursoService.asignarProfesorCurso(proIngles, ingles);
	proIngles.addProfesorEnCurso(enseniaIngles);
	ingles.addProfesorEnCurso(enseniaIngles);
	profesorService.saveProfesorNoDto(proIngles);
	cursoService.saveCursoNoDto(ingles);


	ProfesorEnCurso enseniaIngles2 = profesorEnCursoService.asignarProfesorCurso(proIngles, ingles2);
	proIngles.addProfesorEnCurso(enseniaIngles2);
	ingles2.addProfesorEnCurso(enseniaIngles2);
	profesorService.saveProfesorNoDto(proIngles);
	cursoService.saveCursoNoDto(ingles2);

	ProfesorEnCurso enseniaIngles3 = profesorEnCursoService.asignarProfesorCurso(proIngles, ingles3);
	proIngles.addProfesorEnCurso(enseniaIngles3);
	ingles3.addProfesorEnCurso(enseniaIngles3);
	profesorService.saveProfesorNoDto(proIngles);
	cursoService.saveCursoNoDto(ingles3);


	ProfesorEnCurso enseniaIngles4 = profesorEnCursoService.asignarProfesorCurso(proIngles2, ingles3);
	proIngles2.addProfesorEnCurso(enseniaIngles4);
	ingles3.addProfesorEnCurso(enseniaIngles4);
	profesorService.saveProfesorNoDto(proIngles2);
	cursoService.saveCursoNoDto(ingles3);
	
	System.out.println(proIngles.getProfesorEnCurso());	



	profesorService.deleteProfesorById(proIngles.getId());
		};
	
	}

}
