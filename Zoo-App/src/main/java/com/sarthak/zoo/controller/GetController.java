	package com.sarthak.zoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sarthak.zoo.entity.Zoo;
import com.sarthak.zoo.service.ZooService;

@RestController
public class GetController {
	
	
	@Autowired
	private ZooService zooService;
	
	@GetMapping("/getzoo")
	public List<Zoo> getAllZoo()
	{
		return zooService.getAllZoo();
	}
		
}

