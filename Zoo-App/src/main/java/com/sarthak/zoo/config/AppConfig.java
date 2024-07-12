package com.sarthak.zoo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sarthak.zoo.entity.User;

@Configuration
public class AppConfig {
	
	@Bean
	User user() {
		User user = new User();
		return user;
	}
}
