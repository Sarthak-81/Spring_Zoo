package com.sarthak.zoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarthak.zoo.entity.Animal;
import com.sarthak.zoo.entity.User;
import com.sarthak.zoo.service.AnimalService;
import com.sarthak.zoo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AnimalService animalService;
	
	@GetMapping("/get")	
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
	@GetMapping("/animal")
	public List<Animal> getAllAnimals()
	{
		return animalService.getAllAnimals();
	}
}