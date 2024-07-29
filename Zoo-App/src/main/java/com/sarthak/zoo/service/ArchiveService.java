package com.sarthak.zoo.service;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sarthak.zoo.entity.Zoo;
import com.sarthak.zoo.enums.Entity_Type;
import com.sarthak.zoo.dto.ArchiveDTO;
import com.sarthak.zoo.entity.Animal;
import com.sarthak.zoo.entity.Archive;
import com.sarthak.zoo.mapper.ArchiveMapper;
import com.sarthak.zoo.repository.AnimalRepository;
import com.sarthak.zoo.repository.ArchiveRepository;
import com.sarthak.zoo.repository.ZooRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ArchiveService {

	@Autowired
	private ZooRepository zooRepo;

	@Autowired
	private AnimalRepository animalRepo;

	@Autowired
	private ArchiveRepository archiveRepo;

	@Autowired
	private ArchiveMapper archiveMapper;

	// Method to archive animal
	public ArchiveDTO archiveAnimal(Long id, ArchiveDTO archiveDTO)
	{
		archiveDTO.setAnimalId(id);
		Archive archive = archiveMapper.ArchiveDTOToArchive(archiveDTO);
		
		if(archiveDTO.getEntity_type() != Entity_Type.Animal || archiveDTO.getAnimalId() == null)
		{
			throw new IllegalArgumentException("Invalid archive request for animal");
		}
		 
		Animal animal = animalRepo.findById(archiveDTO.getAnimalId())
				.orElseThrow(() -> new EntityNotFoundException("Animal not found"));
		
		archive.setAnimal_id(animal.getId());
		archive.setZoo_id(null);
		archive.setName(animal.getName());
		archive.setArchive_Date(LocalDate.now());
		Archive savedArchive = archiveRepo.save(archive);
		
		animalRepo.delete(animal);
		
		System.out.println("Animal archived - " + animal.getName());
		
		return 	archiveMapper.archiveToArchiveDTO(savedArchive);
	}
	
	// Method to archive Zoo
	public ArchiveDTO archiveZoo(Long id, ArchiveDTO archiveDTO)
	{
		archiveDTO.setZooId(id);
		
		if(archiveDTO.getEntity_type() != Entity_Type.Zoo || archiveDTO.getZooId()==null) {
			throw new IllegalArgumentException("Invalid archive request for zoo"); }
		
		Zoo zoo = zooRepo.findById(archiveDTO.getZooId())
				.orElseThrow(() -> new EntityNotFoundException("Zoo not found"));
		Archive archive = archiveMapper.ArchiveDTOToArchive(archiveDTO);
		archive.setName(zoo.getName());
		archive.setArchive_Date(LocalDate.now());
		archive.setZoo_id(id);
		archive.setAnimal_id(null);
		
		for(Animal animal : zoo.getAnimals())
		{
			Archive animalArchive = new Archive();
			animalArchive.setName(animal.getName());
			animalArchive.setEntity_type(Entity_Type.Animal);
			animalArchive.setArchive_Date(LocalDate.now());
			animalArchive.setAnimal_id(animal.getId());
			animalArchive.setZoo_id(null);
			animalArchive.setReason("Zoo Archived");
			archiveRepo.save(animalArchive);
			System.out.println("Animal Archived " + animalArchive.getName());
		}
		
		Archive savedArchive = archiveRepo.save(archive);
		
		zooRepo.delete(zoo);
		
		System.out.println("Zoo archived - " + zoo.getName());
		
		return archiveMapper.archiveToArchiveDTO(savedArchive);
	}
}

