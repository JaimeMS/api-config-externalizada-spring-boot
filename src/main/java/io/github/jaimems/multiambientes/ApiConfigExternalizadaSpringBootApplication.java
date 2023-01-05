package io.github.jaimems.multiambientes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiConfigExternalizadaSpringBootApplication {
	
	//variável definida no arquivo application.properties
	@Value("${application.name}")
	private String applicationName;
	
	@GetMapping("/ola-mundo")
	public String olaMundo() {
		return applicationName;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiConfigExternalizadaSpringBootApplication.class, args);
	}

}
