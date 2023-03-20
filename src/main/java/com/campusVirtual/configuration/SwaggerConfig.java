package com.campusVirtual.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openApiConfig() {
		//return new OpenAPI().info(apiInfo());
		
			final String securitySchemeName = "bearerAuth";
			return new OpenAPI().info(apiInfo())
			  .addSecurityItem(new SecurityRequirement()
				.addList(securitySchemeName))
			  .components(new Components()
				.addSecuritySchemes(securitySchemeName, new SecurityScheme()
				  .name(securitySchemeName)
				  .type(SecurityScheme.Type.HTTP)
				  .scheme("bearer")
				  .bearerFormat("JWT")));
			}
	

	private Info apiInfo() {
		Info info = new Info();
		info.title("Java CAMPUS API")
		.description("API REST de campus virtual")
		.version("v1.0.0");
		return info;
	}
	
	
}