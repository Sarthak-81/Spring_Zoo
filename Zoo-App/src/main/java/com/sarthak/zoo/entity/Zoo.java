package com.sarthak.zoo.entity;


import java.util.List;
import javax.validation.constraints.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "zoo")
@Getter
@Setter
@RequiredArgsConstructor
public class Zoo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(nullable=false)
	private String name;
	
	@NotNull
	@Column(nullable=false)
	private String location;
	
	@NotNull
	@Column(nullable=false)
	private String phone_no;
	
	private String description;
	
	// Mapping..............
	
	@OneToOne(mappedBy = "zoo")
	private Archive archive;
	@ManyToMany
	@JoinTable(
	        name = "zoo_animal",
	        joinColumns = @JoinColumn(name = "zoo_id"),
	        inverseJoinColumns = @JoinColumn(name = "animal_id"))
	private List<Animal> animals;
	
	
	
}


