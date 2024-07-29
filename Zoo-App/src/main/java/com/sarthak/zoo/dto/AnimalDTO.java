package com.sarthak.zoo.dto;


import java.util.List;

import javax.validation.constraints.NotEmpty;
import com.sarthak.zoo.entity.Archive;
import com.sarthak.zoo.entity.Transfer;
import com.sarthak.zoo.entity.Zoo;
import com.sarthak.zoo.enums.Gender;
import com.sarthak.zoo.enums.Species;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalDTO {

	@NotEmpty
	private String name;
	@NotEmpty
	private Gender gender;
	@NotEmpty
	private Species species;
	@NotEmpty
	private Long zooId;
	private Archive archive;
	private List<Zoo> zoos;
	private List<Transfer> transferHistory;
	
}
