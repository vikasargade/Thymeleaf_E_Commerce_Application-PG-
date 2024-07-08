package com.jsp.Thymeleaf_E_.Commerce_Application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;
	private int plotNo;
	
	private String landMark;
	private String city;
	private String taluka;
	private String district;
	private String state;
	
	private long pinCode;
	
	@OneToOne(mappedBy = "address")
	PgDetails details;
}
