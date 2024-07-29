package com.sarthak.zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.sarthak.zoo")
public class ZooApplication {
	public static void main(String... args) {
		
		SpringApplication.run(ZooApplication.class, args);
			
	}
}
 
// In transfer_history I want when user enters animal name spring should check if that animal exists in the database or not. If it exists,
// then add its corresponding id in the animal_id field of transfer_history table. 

// STUCK - actionManageHistory 

// Problem - 1. Archiveanimal is not saving animalid and zooid.