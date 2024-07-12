package com.sarthak.zoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarthak.zoo.entity.Animal;
import com.sarthak.zoo.repository.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository animalRepo;
	
	public List<Animal> getAllAnimals(){
		return (List<Animal>) animalRepo.findAll();
	}
}
