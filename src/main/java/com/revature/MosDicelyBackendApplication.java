package com.revature;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.revature.controller.JwtAuthenticationController;
import com.revature.model.User;
import com.revature.repositories.UserDao;

@SpringBootApplication
public class MosDicelyBackendApplication {
	static Logger log = LoggerFactory.getLogger(MosDicelyBackendApplication.class);
	
	public static void main(String[] args) {
		
		log.info("Log works!");
		SpringApplication.run(MosDicelyBackendApplication.class, args);
		
	}
	
	@Bean
	CommandLineRunner init(UserDao userRepository) {
		return args -> {
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(username -> {
					User player = new User(username, "password", 5);
					userRepository.save(player);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}
	
	

}
