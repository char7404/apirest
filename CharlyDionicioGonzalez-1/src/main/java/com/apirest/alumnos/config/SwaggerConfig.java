package com.apirest.alumnos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//AUTODOCUMENTACION//
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.apirest.alumnos.controllers"))//clases a documentar
				.paths(PathSelectors.any())//todas las url
				.build();
	}
}
////////////////-------------1-----------------------
// Mapped URL path [/v2/api-docs]
//localhost:8095/v2/api-docs
////////////////-------------1-----------------------
//visualizar endpoint desde el navegador con swagger:  localhost:8095/swagger-ui.html 
