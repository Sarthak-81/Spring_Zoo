	package com.sarthak.zoo.dto;

import javax.validation.constraints.NotEmpty;
import com.sarthak.zoo.entity.Animal;
import com.sarthak.zoo.entity.Zoo;
import com.sarthak.zoo.enums.Entity_Type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArchiveDTO {

	private Long id;
	@NotEmpty
	private Entity_Type entity_type;
	
	@NotEmpty
	private String reason;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private Long zooId;
	
	@NotEmpty
	private Long animalId;
	
	private Zoo zoo;
	private Animal animalArchive;
}
