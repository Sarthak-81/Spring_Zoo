package com.sarthak.zoo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sarthak.zoo.dto.AnimalDTO;
import com.sarthak.zoo.entity.Animal;
import com.sarthak.zoo.mapper.AnimalMapper;
import com.sarthak.zoo.repository.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	 private AnimalMapper animalMapper;
	
	@Autowired
	private AnimalRepository animalRepo;
		    
	    public AnimalDTO saveAnimal(AnimalDTO animalDTO) {
	        Animal animal = animalMapper.AnimalDTOToAnimal(animalDTO);
	        animal.setArrival_Date(new Date());
	        Animal savedAnimal = animalRepo.save(animal);
	        System.out.println(savedAnimal.getName());
	        System.out.println(savedAnimal.getGender());
	        System.out.println(savedAnimal.getSpecies());
	        System.out.println(savedAnimal.getArrival_Date());
	        return animalMapper.animalToAnimalDTO(savedAnimal);
	    }
	
	
	public Animal addAnimal(AnimalDTO animalDTO)
	{
		Animal animal = new Animal();
		animal.setName(animalDTO.getName());
		animal.setGender(animalDTO.getGender());
		animal.setSpecies(animalDTO.getSpecies());
		return animalRepo.save(animal);
	}
	
	
}
