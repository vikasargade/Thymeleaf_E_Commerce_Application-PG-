package com.jsp.Thymeleaf_E_.Commerce_Application.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Thymeleaf_E_.Commerce_Application.entity.PgDetails;
import com.jsp.Thymeleaf_E_.Commerce_Application.response.ApplicationResponse;
import com.jsp.Thymeleaf_E_.Commerce_Application.service.PgService;

@RestController
@RequestMapping("/api")
public class PgController {

	@Autowired
	private PgService pgService;

	@PostMapping("/pgdetails")
	public ApplicationResponse<PgDetails> registerPg(@RequestBody PgDetails details) {
		PgDetails addedDetails = pgService.addPg(details);
		ApplicationResponse<PgDetails> applicationResponse = new ApplicationResponse("INFORMATION ADDED SUCESSFULLY",
				HttpStatus.CREATED, LocalDateTime.now(), addedDetails);
		return applicationResponse;
	}

	@GetMapping("/pgdetails")
	public ApplicationResponse<PgDetails> getAllPg() {
		List<PgDetails> listOfPg = pgService.getAll();

		ApplicationResponse<PgDetails> applicationResponse = new ApplicationResponse<PgDetails>(
				"RECORDS FOUND SUCESSFULLY!", HttpStatus.FOUND, LocalDateTime.now(), listOfPg);
		return applicationResponse;
	}

	@GetMapping("/pgdetails/{city}")
	public ApplicationResponse<PgDetails> getPgByCity(@PathVariable("city") String city) {
		List<PgDetails> listOfPg = pgService.findByCity(city);
		// System.out.println(listOfPg);
		ApplicationResponse<PgDetails> applicationResponse = new ApplicationResponse<PgDetails>(
				"RECORDS FOUND BASED ON CITY NAME", HttpStatus.FOUND, LocalDateTime.now(), listOfPg);
		return applicationResponse;
	}

	@GetMapping("/pgdetails/name/{pgName}")
	public ApplicationResponse<PgDetails> getPgByName(@PathVariable("pgName") String pgName) {
		List<PgDetails> listOfPg = pgService.findByName(pgName);

		ApplicationResponse<PgDetails> applicationResponse = new ApplicationResponse<PgDetails>(
				"RECORDS FOUND BASED ON PG NAME", HttpStatus.FOUND, LocalDateTime.now(), listOfPg);
		return applicationResponse;
	}

	@GetMapping("/pgdetails/id/{id}")
	public ApplicationResponse<PgDetails> getPgById(@PathVariable("id") int id) {
		PgDetails pg = pgService.findById(id);

		ApplicationResponse<PgDetails> applicationResponse;
		if (pg != null) {
			return new ApplicationResponse<PgDetails>("PG FOUND SUCCESSFULLY", HttpStatus.FOUND, LocalDateTime.now(),
					pg);
		} else {
			return new ApplicationResponse<PgDetails>("PG NOT FOUND", HttpStatus.NOT_FOUND, LocalDateTime.now(), pg);
		}
	}

	@DeleteMapping("/pgdetails/{id}")
	public ApplicationResponse<PgDetails> removePgById(@PathVariable("id") int id) {
		pgService.deletePg(id);
		ApplicationResponse<PgDetails> applicationResponse = new ApplicationResponse<PgDetails>("RECORD DELETED!",
				HttpStatus.NO_CONTENT, LocalDateTime.now());

		return applicationResponse;
	}

	@GetMapping("/pgdetails/keyword/{keyword}") // coding done with only for pg.id and pg.name
	public ApplicationResponse<PgDetails> findByKeyword(@PathVariable("keyword") String keyword) {
		List<PgDetails> listOfPg = pgService.getDetailByKeyword(keyword);

		ApplicationResponse<PgDetails> applicationResponse = new ApplicationResponse<PgDetails>("RECORDS FOUND",
				HttpStatus.FOUND, LocalDateTime.now(), listOfPg);

		return applicationResponse; 
	}
}
