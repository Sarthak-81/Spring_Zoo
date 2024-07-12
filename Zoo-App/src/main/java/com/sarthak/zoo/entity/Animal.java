package com.sarthak.zoo.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.sarthak.zoo.enums.Gender;
import com.sarthak.zoo.enums.Species;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
	private String Name;
	private Gender gender;
	private Species species;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date Arrival_Date;
	
	@OneToOne
		@JoinColumn(name = "entity_id")
		private Archive archive;
	
	
	@ManyToOne
		@JoinColumn(name = "object_id")
		private Photo photo;
	
	@ManyToOne
		@JoinColumn(name = "animal_id")
		private Transfer_History history;
	
	 @ManyToMany(mappedBy = "animals")
	    private Set<Zoo> zoos = new HashSet<>();
	
}

