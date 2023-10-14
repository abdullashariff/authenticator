package com.akiro.authenticator;

import com.akiro.authenticator.controllers.service.GeneratorService;
import com.akiro.authenticator.controllers.service.ValidatorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AuthenticatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticatorApplication.class, args);
	}


	@GetMapping
	String healthCheck(){
		return "success";
	}


	@Bean
	public GeneratorService getTokenGenerator(){
		return new GeneratorService();
	}

	@Bean
	public ValidatorService getTokenValidator(){
		return new ValidatorService();
	}

}
