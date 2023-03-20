package com.campusVirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import com.campusVirtual.model.Userdata;
import com.campusVirtual.dto.ProfessorDto;
import com.campusVirtual.model.Course;
import com.campusVirtual.service.ICourseService;
import com.campusVirtual.service.IProfessorInCourseService;
import com.campusVirtual.service.IProfessorService;
import com.campusVirtual.service.IStudentInCourseService;
import com.campusVirtual.service.IStudentService;
import com.campusVirtual.service.IUserDataService;

@SpringBootApplication
public class CampusApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampusApiApplication.class, args);
	}
 
	@Bean
    CommandLineRunner commandLineRunner(
			IStudentService studentService,
			IUserDataService userDataService,
			IProfessorService professorService,
			ICourseService ico,
			IProfessorInCourseService pic,
			IStudentInCourseService sic,
			PasswordEncoder passwordEncoder
			){
	return args -> {
		
		String allPass = passwordEncoder.encode("password");

		Userdata admin = new Userdata((long)1,allPass,"name","last","mailAdmin");
		admin.addAuthorities("ROLE_ADMIN");
		userDataService.saveUser(admin);


		userDataService.saveUser(new Userdata((long)111,allPass,"name","last","mail"));
		studentService.saveStudent((long)111);

		userDataService.saveUser(new Userdata((long)222,allPass,"name","last","mail1"));
		studentService.saveStudent((long)222);

		userDataService.saveUser(new Userdata((long)333,allPass,"name","last","ad1"));
		professorService.saveProfessor(new ProfessorDto("ingles"), (long)333);
		
		userDataService.saveUser(new Userdata((long)444,allPass,"name","last","ad2"));
		professorService.saveProfessor(new ProfessorDto("redes"), (long)444);

		
		ico.saveCourse(new Course("Ingles"));
		ico.saveCourse(new Course("reded"));
		ico.saveCourse(new Course("redes"));

		pic.setProfessorInCourse((long)1, (long)1);
		pic.setProfessorInCourse((long)2, (long)3);

		sic.setStudentInCourse((long)1, (long)1);
		sic.setStudentInCourse((long)1, (long)2);
		sic.setStudentInCourse((long)2, (long)2);
		
	
		
	};
	
	}

	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
    		return new WebMvcConfigurer() {
        		@Override
        		public void addCorsMappings(CorsRegistry registry) {
            		registry.addMapping("/**")
                	.allowedOrigins("http://localhost:4200/login")
					.allowedOrigins("http://localhost:4200")
					.allowedOrigins("*")
					.allowedHeaders("*");
        		}
  		  };
	}
	

}
