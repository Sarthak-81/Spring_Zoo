package com.sarthak.zoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
	
	@PostMapping("/add")
	public ResponseEntity<ArchiveDTO> addArchive(@Validated @RequestBody ArchiveDTO archiveDTO) 
	{
		ArchiveDTO newArchive = archiveService.saveArchive(archiveDTO);
		return ResponseEntity.ok(newArchive);
	}
	
}
