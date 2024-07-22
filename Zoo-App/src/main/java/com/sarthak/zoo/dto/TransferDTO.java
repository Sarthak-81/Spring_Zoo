package com.sarthak.zoo.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferDTO {
	@NotEmpty
	private String name;
	@NotEmpty
	private String reason;
	@NotEmpty
	private Date Transfer_Date;
	private String From_Zoo;
	private String To_Zoo;
	
}
