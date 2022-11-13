package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Component
public class SwaggerConfig {
	
	@Bean
	public Docket getDocket() {
		
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-apis")
				.apiInfo(getApiInfo())
				.select().build();
	}
	
	public ApiInfo getApiInfo() {
		
		return new ApiInfoBuilder().title("Smart Contact APIS")
				.description("ApI Created For Smart Contact ").build();
	}

}
