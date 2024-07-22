package com.sarthak.zoo.entity;

import java.sql.Date;
import java.util.List;

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
@Table(name="Photo")
@Setter
@Getter
public class Photo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column
	private String name;
	@Column
	private String caption;
	@Column
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date upload_date;
	@Column
	private String photo_url;
	@Column
	private String object_type;
	@Column
	private int object_id;	
	
	
}
