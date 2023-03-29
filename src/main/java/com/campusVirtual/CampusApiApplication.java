package com.campusVirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import com.campusVirtual.model.Userdata;
import com.campusVirtual.dto.CourseContentDto;
import com.campusVirtual.dto.ProfessorDto;
import com.campusVirtual.model.Course;
import com.campusVirtual.service.ICourseContentService;
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
			ICourseContentService icc,
			ICourseService ico
		){

			return args -> {
				ico.saveCourse(new Course("redes"));

				CourseContentDto ccdto=new CourseContentDto();
				ccdto.setContent("Hi Students Welcome to Redes");

				icc.addCourseContent((long)1, ccdto);
			};
		}
 /* 
	@Bean
    CommandLineRunner commandLineRunner(
			IStudentService studentService,
			IUserDataService userDataService,
			IProfessorService professorService,
			ICourseService ico,
			IProfessorInCourseService pic,
			IStudentInCourseService sic,
			PasswordEncoder passwordEncoder,
			ICourseContentService icc
			){
	return args -> {
		
		String allPass = passwordEncoder.encode("password");

		Userdata admin = new Userdata("admin",allPass,"name","last","mailAdmin");
		admin.addAuthorities("ROLE_ADMIN");
		userDataService.saveUser(admin);


		userDataService.saveUser(new Userdata("pa",allPass,"name","last","mail"));
		studentService.saveStudent("pa");

		userDataService.saveUser(new Userdata("pe",allPass,"name","last","mail1"));
		studentService.saveStudent("pe");

		userDataService.saveUser(new Userdata("pi",allPass,"name","last","ad1"));
		professorService.saveProfessor(new ProfessorDto("ingles"), "pi");
		
		userDataService.saveUser(new Userdata("po",allPass,"name","last","ad2"));
		professorService.saveProfessor(new ProfessorDto("redes"), "po");

		
		ico.saveCourse(new Course("Ingles"));
		ico.saveCourse(new Course("reded"));
		ico.saveCourse(new Course("redes"));
		
		CourseContentDto ccDtos = new CourseContentDto();
		ccDtos.setContent("hola alumonos");

		icc.addCourseContent((long)1, ccDtos);
		icc.addCourseContent((long)1, ccDtos);
		icc.addCourseContent((long)2, ccDtos);

		System.out.println(icc.getAllCourseContent((long)1)); 

		pic.setProfessorInCourse((long)1, (long)1);
		pic.setProfessorInCourse((long)2, (long)3);

		sic.setStudentInCourse((long)1, (long)1);
		sic.setStudentInCourse((long)1, (long)2);
		sic.setStudentInCourse((long)2, (long)2);
		
	
		
	};
	
	}

	*/
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
