package com.jsp.Thymeleaf_E_.Commerce_Application.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Amenities {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int amenitiesID;
	
	private List<String> amenitiesName;
	
	@ManyToMany
	private List<PgDetails> pgDetails;

	public Amenities(List<String> amenitiesName) {
		super();
		this.amenitiesName = amenitiesName;
	}

	
	
	
	
}
