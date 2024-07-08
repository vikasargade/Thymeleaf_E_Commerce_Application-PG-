package com.jsp.Thymeleaf_E_.Commerce_Application.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	
	private String customerName;
	private String customerEmail;
	private String customerGender;
	private String adharCard;
	
	private long customerMobile;
	
	private Date customerDate;
	
	@ManyToOne
	private PgDetails pgDetails;
	
	@OneToMany(mappedBy = "customer")
	private List<BookingDetails> bookingDetails;
}
