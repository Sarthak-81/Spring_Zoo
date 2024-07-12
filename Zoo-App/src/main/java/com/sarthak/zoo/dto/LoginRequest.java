package com.sarthak.zoo.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest 
{
	
	@NotEmpty
	private String name;
	@NotEmpty
	private String password;
}
