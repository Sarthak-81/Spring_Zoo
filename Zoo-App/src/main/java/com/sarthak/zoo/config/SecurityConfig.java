package com.sarthak.zoo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import com.sarthak.zoo.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
	
	// The purpose of requestMatchers() is to specify which requests the spring security configuration will be applied to.
	
	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                                .requestMatchers("/", "/login", "/getzoo", "/animal/add", "/zoo/add", "/zoo/delete/{id}", "/zoo/update/{id}", "archive/addanimal/{id}", 
                                		"archive/addzoo/{id}", "history/add", "animal/addinzoo/{id}", "/history/add/{id}").permitAll()
                                .anyRequest()
                                .authenticated()
                           
                )
                .csrf(csrf -> csrf.disable());
	
	return http.build();
	}
	
	@Bean
	protected UserDetailsService userDetailsService() {
		return new CustomUserDetailService();
	}		

}
