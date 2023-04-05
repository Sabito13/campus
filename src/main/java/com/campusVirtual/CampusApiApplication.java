package com.campusVirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.context.annotation.Bean;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



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
					.allowedMethods("GET","POST","PUT","DELETE")
					.allowedHeaders("*");
        		}
  		  };
	}
	

}
