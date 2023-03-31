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
