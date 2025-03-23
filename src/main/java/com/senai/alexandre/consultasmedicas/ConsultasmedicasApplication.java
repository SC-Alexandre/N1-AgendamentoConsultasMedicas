package com.senai.alexandre.consultasmedicas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @io.swagger.v3.oas.annotations.info.Info(title = "${info.build.name}",
				version = "${info.build.version}",
				description = "${info.app.description}",
				contact = @io.swagger.v3.oas.annotations.info.Contact(name = "Alexandre dos Santos Cunha", email = "josemaurosilva600@gmail.com")))

@SpringBootApplication
public class ConsultasmedicasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultasmedicasApplication.class, args);
	}

}
