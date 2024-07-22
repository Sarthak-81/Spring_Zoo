package com.sarthak.zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sarthak.zoo"})
public class ZooApplication {

	public static void main(String... args) {
		
		SpringApplication.run(ZooApplication.class, args);
	}
}
 


