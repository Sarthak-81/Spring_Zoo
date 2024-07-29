package com.sarthak.zoo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sarthak.zoo.dto.AnimalDTO;
import com.sarthak.zoo.entity.Animal;
import com.sarthak.zoo.entity.Zoo;
import com.sarthak.zoo.mapper.AnimalMapper;
import com.sarthak.zoo.repository.AnimalRepository;
import com.sarthak.zoo.repository.ZooRepository;

import jakarta.transaction.Transactional;

@Service
public class AnimalService {
	
	@Autowired
	 private AnimalMapper animalMapper;
	
	@Autowired
	private ZooRepository zooRepo;
	
	@Autowired
	private AnimalRepository animalRepo;
		    
	// To save animal 
	    @Transactional
	    public AnimalDTO saveAnimal(AnimalDTO animalDTO) {
	        Zoo zoo = zooRepo.findById(animalDTO.getZooId())
	            .orElseThrow(() -> new RuntimeException("Zoo not found"));

	        Animal animal = animalMapper.AnimalDTOToAnimal(animalDTO);
	        animal.setZoo(zoo); 
	        animal.setZoo_id(animalDTO.getZooId());

	        Animal savedAnimal = animalRepo.save(animal);
	        System.out.println(animal.getName() + " saved in " + zoo.getName());
	        return animalMapper.animalToAnimalDTO(savedAnimal);
	    }
	
	    // To save animal in a 	particular zoo
	    public AnimalDTO saveAnimalInZoo(Long id, AnimalDTO animalDTO)
	    {
	    	Zoo zoo = zooRepo.findById(id).orElseThrow(() -> new RuntimeException("Zoo not found"));
	    	Animal animal = animalMapper.AnimalDTOToAnimal(animalDTO);
	    	animal.setZoo(zoo);
	    
	    	Animal savedAnimal = animalRepo.save(animal);
	    	System.out.println("---------------------");
	    	System.out.println(animal.getName() +  " saved in " + zoo.getName());
	    	return animalMapper.animalToAnimalDTO(savedAnimal);
	    }
}

// Method to get all animals with their zoo information
//@Transactional
//public List<AnimalDTO> getAllAnimals() {
//    List<Animal> animals = animalRepo.findAll();
//    return animals.stream()
//        .map(animalMapper::animalToAnimalDTO)
//        .collect(Collectors.toList());
//}


