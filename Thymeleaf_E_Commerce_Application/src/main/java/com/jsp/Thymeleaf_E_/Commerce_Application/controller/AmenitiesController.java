package com.jsp.Thymeleaf_E_.Commerce_Application.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Thymeleaf_E_.Commerce_Application.entity.Amenities;
import com.jsp.Thymeleaf_E_.Commerce_Application.entity.PgDetails;
import com.jsp.Thymeleaf_E_.Commerce_Application.response.ApplicationResponse;
import com.jsp.Thymeleaf_E_.Commerce_Application.service.PgService;
import com.jsp.Thymeleaf_E_.Commerce_Application.service.AmenitiesService;

@RestController
@RequestMapping("/api")
public class AmenitiesController {

	@Autowired
	private PgService pgService;

	@Autowired
	private AmenitiesService amenitiesService;

	@PostMapping("/amenities/{pId}")
	public ApplicationResponse<PgDetails> addAmenities(@RequestBody Amenities amenities, @PathVariable("pId") int pId) {

		PgDetails pgFromDB = amenitiesService.addAmenitiesToPg(pId, amenities);

		ApplicationResponse<PgDetails> applicationResponse = new ApplicationResponse<PgDetails>(
				"AMENTITES ADDED TO THE PG", HttpStatus.ACCEPTED, LocalDateTime.now(), pgFromDB);

		return applicationResponse;
	}

}
