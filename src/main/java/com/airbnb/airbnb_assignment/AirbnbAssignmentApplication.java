package com.airbnb.airbnb_assignment;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*" ,allowedHeaders = "*" )
@SpringBootApplication
public class AirbnbAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirbnbAssignmentApplication.class, args);
    }
	@Bean
	public ModelMapper getModelMapper(){
		return new  ModelMapper();
	}
}
