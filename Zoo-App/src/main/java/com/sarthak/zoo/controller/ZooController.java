package com.sarthak.zoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarthak.zoo.dto.ZooDTO;
import com.sarthak.zoo.service.ZooService;

@RestController
@RequestMapping("/zoo")
public class ZooController {

	@Autowired
	private ZooService zooService;
	
	@PostMapping("/add")
	public ResponseEntity<ZooDTO> addZoo(@Validated @RequestBody ZooDTO zooDTO)
	{
		ZooDTO newZoo = zooService.saveZoo(zooDTO);
		System.out.println("--------------------------------------------------");
		return ResponseEntity.ok(newZoo);		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteZoo(@PathVariable Long id)
	{
		zooService.deleteZoo(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ZooDTO> editZoo(@PathVariable Long id, @Validated @RequestBody ZooDTO zooDTO)
	{
		ZooDTO editedZoo = zooService.updateZoo(id, zooDTO);
		
		return ResponseEntity.ok(editedZoo);
	}
	
} 
//

 