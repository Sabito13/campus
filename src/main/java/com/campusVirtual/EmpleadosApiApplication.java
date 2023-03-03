package com.campusVirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.campusVirtual.model.Curso;
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
	
	

	profesorEnCursoService.asignarProfesorCurso(proRedes.getId(), redes.getId());
	
	profesorEnCursoService.asignarProfesorCurso(proIngles.getId(), ingles.getId());
	
	profesorEnCursoService.asignarProfesorCurso(proIngles.getId(), ingles2.getId());
	
	profesorEnCursoService.asignarProfesorCurso(proIngles.getId(), ingles3.getId());

	profesorEnCursoService.asignarProfesorCurso(proIngles2.getId(), ingles3.getId());
	
	System.out.println(profesorService.getProfesorNoDtoById(proIngles.getId()).getProfesorEnCurso());	

	//profesorService.deleteProfesorById(proIngles.getId());
		};
	
	}

}
