package com.jsp.Thymeleaf_E_.Commerce_Application.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.websocket.OnError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PgDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pgId;
	private int pgSharing;
	private int noOfRooms;
	private int noOfOccupiedRooms;
	
	private String pgName;
	private String category;
	private String pgEmail;
	
	private long pgMobile;
	
	private double pgDeposit;
	private double pgRent;
	
	@OneToMany(mappedBy = "pgDetails")
	private List<Customer> customers;
	
	@OneToMany(mappedBy = "pg")
	private List<Staff> staffList;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@ManyToMany(mappedBy = "pgDetails")
	private List<Amenities> amenities;
	
	@OneToMany(mappedBy = "pgDetails")
	private List<BookingDetails> bookingDetails; 
	
}
