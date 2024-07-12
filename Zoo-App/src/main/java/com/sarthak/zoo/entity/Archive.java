package com.sarthak.zoo.entity;

import java.sql.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.sarthak.zoo.enums.Entity_Type;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Archive")
@Getter
@Setter
public class Archive {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String Reason;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date Arrival_Date;
	private Entity_Type entity_type;
	private long entity_id;
	private String name;
	
	@OneToOne(mappedBy = "archive")
	private Zoo zoo;
	
	@OneToOne(mappedBy = "archive")
	private Animal animal;
	
}
