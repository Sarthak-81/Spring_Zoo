package com.sarthak.zoo.entity;

import java.time.LocalDate;
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
	private Long id;
	
	@Column(name = "reason", nullable=false)
	private String Reason;
	
	@Column(name = "archive_date", nullable=false)
	private LocalDate Archive_Date;
	
	@Column(name = "entity_type", nullable=false)
	@Enumerated(EnumType.STRING)
	private Entity_Type entity_type;
	
	@Column(name = "animal_id", insertable=false, updatable=false)
	private Long animal_id;
	
	@Column(name = "zoo_id", insertable=false, updatable=false)
	private Long zoo_id;
	
	@Column(name = "name", nullable=false)
	private String name;
	
	// Mapping..........
	
	@OneToOne
	@JoinColumn(name="zoo_id", referencedColumnName = "id")
	private Zoo zoo;
	
	@OneToOne
	@JoinColumn(name="animal_id", referencedColumnName = "id")
	private Animal animalArchive;
	
	public Archive()
	{
		this.Archive_Date = LocalDate.now();
	}
	
}

