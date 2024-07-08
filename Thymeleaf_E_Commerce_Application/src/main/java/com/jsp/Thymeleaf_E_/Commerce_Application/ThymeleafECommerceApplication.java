package com.jsp.Thymeleaf_E_.Commerce_Application;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jsp.Thymeleaf_E_.Commerce_Application.entity.Amenities;
import com.jsp.Thymeleaf_E_.Commerce_Application.entity.Role;
import com.jsp.Thymeleaf_E_.Commerce_Application.repository.AmenitiesRepository;
import com.jsp.Thymeleaf_E_.Commerce_Application.repository.RoleRepository;

@SpringBootApplication
public class ThymeleafECommerceApplication  { // implements CommandLineRunner {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private AmenitiesRepository amenitiesRepository;

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafECommerceApplication.class, args);
	}


//	Storing all the catagories into the data base
//	@Override
	public void run(String... args) throws Exception
	{
////		to execute any code at the starting of an application
////		
////		these are the categories given by developer --> so after inserting into table make it as comment
//		List<Role> roles = Arrays.asList(          
//				new Role("Admin"),
//				new Role("Cook"),
//				new Role("Cleaner"),
//				new Role("Security"),
//				new Role("Care Taker"),
//				new Role("Owner")
//				);
//		
//		List<Amenities> amenities = Arrays.asList(
//				new Amenities("Wi-Fi"),
//				new Amenities("Washing Machine"),
//				new Amenities("Drinking Water"),
//				new Amenities("Cupboard"),
//				new Amenities("TV"),
//				new Amenities("AC"),
//				new Amenities("CCTV"),
//				new Amenities("Parking")
//				);
//		
//		roleRepository.saveAll(roles);
//		amenitiesRepository.saveAll(amenities);
	}
}
