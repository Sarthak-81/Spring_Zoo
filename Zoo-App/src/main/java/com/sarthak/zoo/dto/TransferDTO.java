package com.sarthak.zoo.dto;

import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferDTO {
	
	private Long id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String reason;
	@NotEmpty
	private LocalDate transferDate;
	@NotEmpty
	private String fromZooName;
	@NotEmpty
	private String toZooName;
	
	
	private long animalId;
}
