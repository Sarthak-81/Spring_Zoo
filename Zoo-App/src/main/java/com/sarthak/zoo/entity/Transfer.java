package com.sarthak.zoo.entity;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	private long from_zoo_id;
	
	private long to_zoo_id;
	
	private long animal_id;
	
	@NotNull
	@Column(nullable=false)
	private String reason;
	
	@NotNull
	@Column(nullable=false)
	private String name;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date Transfer_Date;
	
	// Mapping...................
	
	@ManyToOne
	private Animal animalTransfer;
	
}
