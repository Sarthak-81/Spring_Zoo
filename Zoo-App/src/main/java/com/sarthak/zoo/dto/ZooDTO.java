package com.sarthak.zoo.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.sarthak.zoo.entity.Animal;
import com.sarthak.zoo.entity.Archive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZooDTO {

	@NotEmpty
	private String name;
	@NotEmpty
	private String location; 
	@NotEmpty
	private String phone_no;
	@NotEmpty
	private String description;
	private Archive archive;
	private List<Animal> animals;
}
