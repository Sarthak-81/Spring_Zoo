package com.sarthak.zoo.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "zoo")
@Getter
@Setter
public class Zoo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", nullable=false)
	private String name;
	
	@Column(name = "location", nullable=false)
	private String location;
	
	@Column(name = "phone_no", nullable=false)
	private String phone_no;
	
	@Column(name = "description", nullable=false)
	private String description;
	
	//Mapping between Zoo and Animal
	@OneToMany(mappedBy = "zoo", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Animal> animals;
		
	
	// Mapping between Zoo and Archive
	@OneToOne(mappedBy = "zoo")
	private Archive archive;
	
	
	
}


