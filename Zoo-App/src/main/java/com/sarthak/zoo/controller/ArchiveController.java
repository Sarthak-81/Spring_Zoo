package com.sarthak.zoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sarthak.zoo.dto.ArchiveDTO;
import com.sarthak.zoo.service.ArchiveService;

@RequestMapping("/archive")
@RestController

public class ArchiveController {

	@Autowired
	private ArchiveService archiveService;
	
	@PostMapping("/addanimal/{id}")
	public ResponseEntity<ArchiveDTO> addArchiveAnimal(@PathVariable Long id, @Validated @RequestBody ArchiveDTO archiveDTO) 
	{
		ArchiveDTO savedAnimal = archiveService.archiveAnimal(id, archiveDTO);
		
		return ResponseEntity.ok(savedAnimal);
	}
	
	@PostMapping("/addzoo/{id}")
	public ResponseEntity<ArchiveDTO> addArchiveZoo(@PathVariable Long id, @Validated @RequestBody ArchiveDTO archiveDTO)
	{
		ArchiveDTO savedZoo = archiveService.archiveZoo(id, archiveDTO);
		
		return ResponseEntity.ok(savedZoo);
	}
	
}
