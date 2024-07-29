package com.sarthak.zoo.entity;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transfer_history")
@Getter
@Setter
public class Transfer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="from_zoo_id")
	private long from_zoo_id;
	
	@Column(name="to_zoo_id")
	private long to_zoo_id;
	
	@Column(name = "animal_id")
	private long animal_id;
	
	@Column(name = "reason", nullable=false)
	private String reason;
	
	@Column(name = "name", nullable=false)
	private String name;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate Transfer_Date;
	
	// Mapping between Transfer and Animal
	@ManyToOne
	@JoinColumn(name="animal_transfer_id")
	private Animal animalTransfer;
	
}
