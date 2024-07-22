package com.sarthak.zoo.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.sarthak.zoo.entity.Animal;
import com.sarthak.zoo.entity.Zoo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArchiveDTO {

	@NotEmpty
	private String entity_type;
	@NotEmpty
	private String name;
	@NotEmpty
	private String reason;
	@NotEmpty
	private Date Archive_Date;
	private Zoo zoo;
	private Animal animalArchive;
}
