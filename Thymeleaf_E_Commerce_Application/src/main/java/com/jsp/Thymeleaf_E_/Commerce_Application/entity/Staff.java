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
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int staffId;
	
	private String fName;
	private String lName;
	private String staffEmail;
	private String staffGender;	
	private long staffAadharCard;
	private String staffBankName;
	private String bankIfscCode;
	
	private long staffMobile;
	private long staffAccountNumber;
		
	private Date staffDob;
	
	@ManyToOne
	private PgDetails pg;
}
