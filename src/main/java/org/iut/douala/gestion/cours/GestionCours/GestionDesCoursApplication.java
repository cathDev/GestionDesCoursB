package org.iut.douala.gestion.cours.GestionCours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class GestionDesCoursApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(GestionDesCoursApplication.class, args);
		
	}
	
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder(); 
	}
	
	/*@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
	*/

}

