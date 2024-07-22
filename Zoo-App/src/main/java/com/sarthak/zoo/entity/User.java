package com.sarthak.zoo.entity;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(nullable=false)
	private String name;
	
	@NotNull
	@Column(nullable=false)
	private String email;
	
	@NotNull
	@Column(nullable=false)
	private String password;
	
	// role can be USER, ADMIN 
	private String role;
	
}
