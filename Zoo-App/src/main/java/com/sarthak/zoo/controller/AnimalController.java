	package com.sarthak.zoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarthak.zoo.dto.AnimalDTO;
import com.sarthak.zoo.service.AnimalService;

@RestController
@RequestMapping("/animal")
public class AnimalController {

	@Autowired
	private AnimalService animalService;	
	
	@PostMapping("/add")
	public ResponseEntity<AnimalDTO> addAnimal(@Validated @RequestBody AnimalDTO animalDTO)
	{
		AnimalDTO newAnimal = animalService.saveAnimal(animalDTO);
		System.out.println("-------------------------------------");		
		return ResponseEntity.ok(newAnimal);
	}
	
	@PostMapping("/addinzoo/{id}")
	public ResponseEntity<AnimalDTO> addAnimalInZoo(@PathVariable Long id, @Validated @RequestBody AnimalDTO animalDTO)
	{
		AnimalDTO newAnimal = animalService.saveAnimalInZoo(id, animalDTO);
		System.out.println("---------------------");
		return ResponseEntity.ok(newAnimal);
	}
}