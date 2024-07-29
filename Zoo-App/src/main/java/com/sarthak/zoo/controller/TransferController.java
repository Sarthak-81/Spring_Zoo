package com.sarthak.zoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarthak.zoo.dto.TransferDTO;
import com.sarthak.zoo.service.TransferService;

@RestController
@RequestMapping("/history")
public class TransferController 
{

	@Autowired
	private TransferService transferService;
	
	@PostMapping("/add/{id}")
	public ResponseEntity<TransferDTO> addHistory(@PathVariable Long id, @Validated @RequestBody TransferDTO transferDTO)
	{
		TransferDTO newHistory = transferService.saveHistory(id, transferDTO);
		System.out.println("--------------------------------------------------");
		return ResponseEntity.ok(newHistory);
	}
}
