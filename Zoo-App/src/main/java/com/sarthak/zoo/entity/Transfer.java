package com.sarthak.zoo.entity;

import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Transfer_History")
@Getter
@Setter
public class Transfer_History {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long From_zoo_id;
	private long To_zoo_id;
	private long animal_id;
	private String Reason;
	private String Animal;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date Transfer_Date;
	
	@OneToMany(mappedBy = "history")
		private List<Animal> animals;
}
