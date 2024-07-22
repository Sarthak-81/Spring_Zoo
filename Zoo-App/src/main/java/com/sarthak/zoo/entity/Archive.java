package com.sarthak.zoo.entity;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import com.sarthak.zoo.enums.Entity_Type;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "archive")
@Getter
@Setter
public class Archive {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(nullable=false)
	private String Reason;
	
	@NotNull
	@Column(nullable=false)
	private LocalDate Archive_Date;
	
	@NotNull
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private Entity_Type entity_type;
	
	private long entity_id;
	
	@NotNull
	@Column(nullable=false)
	private String name;
	
	// Mapping..........
	
	@OneToOne
	@JoinColumn(name="zoo_id")
	private Zoo zoo;
	
	@OneToOne
	@JoinColumn(name="animal_id")
	private Animal animalArchive;
	
	public Archive()
	{
		this.Archive_Date = LocalDate.now();
	}
	
}

