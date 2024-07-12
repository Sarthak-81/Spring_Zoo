package com.sarthak.zoo.entity;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Zoo")
@Getter
@Setter
public class Zoo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String Name;
	private String Location;
	private int Phone_no;
	private String Description;
	
	@OneToOne
		@JoinColumn(name = "entity_id")
		private Archive archive;
	
	@ManyToOne
		@JoinColumn(name = "object_id")
		private Photo photo;
	
	 @ManyToMany
	    @JoinTable(
	        name = "Zoo_Animal",
	        joinColumns = @JoinColumn(name = "zoo_id"),
	        inverseJoinColumns = @JoinColumn(name = "animal_id")
	    )
	    private Set<Animal> animals = new HashSet<>();
	
}
