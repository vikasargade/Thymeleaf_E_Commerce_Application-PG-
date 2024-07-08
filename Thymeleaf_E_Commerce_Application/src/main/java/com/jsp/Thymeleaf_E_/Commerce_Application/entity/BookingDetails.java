package com.jsp.Thymeleaf_E_.Commerce_Application.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private LocalDate bookingDate;
	private LocalDate checkIn;
	
	private boolean advancedPaymentStatus;
	private  boolean rentStatus;
	private boolean bookingStatus;
	
	@ManyToOne
	private PgDetails pgDetails;
	
	@ManyToOne
	private Customer customer;
}
