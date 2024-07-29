package com.sarthak.zoo.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.sarthak.zoo.enums.Gender;
import com.sarthak.zoo.enums.Species;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "animal")
@Getter
@Setter
public class Animal {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", nullable=false)
	private String Name;
	
	@Column(name = "gender",nullable=false)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name = "species", nullable=false)
	@Enumerated(EnumType.STRING)
	private Species species;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "arrival_date", nullable=false)
	private LocalDate Arrival_Date;
	
	@Column(name = "zoo_id", insertable = false, updatable=false)
	private Long zoo_id;
	
	public Animal()
	{
		this.Arrival_Date = LocalDate.now();
	}
	
	// Mapping between Archive and Animal
	@OneToOne(mappedBy = "animalArchive")
	private Archive archive;
	
	// Mapping between Transfer and Animal
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "animalTransfer")
	private List<Transfer> transfers;
	
    // Mapping between Animal and Zoo
	@ManyToOne
	@JoinColumn(name="zoo_id", nullable=false)
	private Zoo zoo;
	
}


