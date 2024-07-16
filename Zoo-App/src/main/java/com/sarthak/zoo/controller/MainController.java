package com.sarthak.zoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sarthak.zoo.entity.User;
import com.sarthak.zoo.dto.LoginRequest;
import com.sarthak.zoo.dto.SignupRequest;
import com.sarthak.zoo.service.LoginService;
import com.sarthak.zoo.service.SignupService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private SignupService signupService;
	
	// login is successful in UI but user has to click 2 times and user details are not consoling.
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) 
	{
		if (loginService.authenticate(loginRequest.getName(), loginRequest.getPassword())) 
		{
			System.out.println("Name: " + loginRequest.getName() + " |" + " Password: " + loginRequest.getPassword());
			return ResponseEntity.ok("Success");
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body("Invalid credentials");
	}
	
	// Duplicate entry is because when user is signing in, yii2 already creates that user and when request is sent to spring it says duplicate entry.
	@PostMapping("/signup")
	public ResponseEntity<User> signup(@Validated @RequestBody SignupRequest signupRequest)
	{
		User user = signupService.saveUser(signupRequest);
		System.out.println("Username: " + signupRequest.getName() + " |" + " Email: " + signupRequest.getEmail() + " |" +  " Password: " + signupRequest.getPassword());
		return ResponseEntity.ok(user);
	}
}
