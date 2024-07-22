package com.sarthak.zoo.entity;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import com.sarthak.zoo.enums.Gender;
import com.sarthak.zoo.enums.Species;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	
	@NotNull
	@Column(nullable=false)
	private String Name;
	
	@NotNull
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@NotNull
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private Species species;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date Arrival_Date;
	
	private long zoo_id;
	
	// Mapping............
	
	@OneToOne(mappedBy = "animalArchive")
	private Archive archive;
	
	@OneToMany(mappedBy = "animalTransfer")
	private List<Transfer> transferHistory;
	
	@ManyToMany(mappedBy = "animals")
	private List<Zoo> zoos;
	
}



