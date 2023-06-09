package com.example.restful_webservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.restful_webservice.user.UserService;

@SpringBootApplication
public class RestfulWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebserviceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserService userService) {
		return args -> System.out.println("My application got started!!");
	}

}
