package com.jsp.Thymeleaf_E_.Commerce_Application.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Thymeleaf_E_.Commerce_Application.entity.PgDetails;
import com.jsp.Thymeleaf_E_.Commerce_Application.entity.Staff;
import com.jsp.Thymeleaf_E_.Commerce_Application.response.ApplicationResponse;
import com.jsp.Thymeleaf_E_.Commerce_Application.service.PgService;
import com.jsp.Thymeleaf_E_.Commerce_Application.service.StaffService;

@RestController
@RequestMapping("/api")
public class StaffController {

	@Autowired
	private StaffService staffService;

	@PostMapping("/staff/{pgId}")
	public ApplicationResponse<PgDetails> addStaff(@RequestBody Staff staff, @PathVariable("pgId") int pgId) {
		PgDetails pgWithStaff = staffService.addStaffToPg(pgId, staff);

		ApplicationResponse<PgDetails> applicationResponse = new ApplicationResponse<PgDetails>(
				"STAFF DETAILS IS UPDATED TO PG", HttpStatus.ACCEPTED, LocalDateTime.now(), pgWithStaff);

		return applicationResponse;
	}

	@GetMapping("/staff")
	public ApplicationResponse<Staff> getAllStaff() {
		List<Staff> listOfStaff = staffService.findAllStaff();

		ApplicationResponse<Staff> applicationResponse = new ApplicationResponse<Staff>("RECORDS ARE FOUND",
				HttpStatus.FOUND, LocalDateTime.now(), listOfStaff);
		return applicationResponse;
	}
	
	@GetMapping("/staff/{id}")
	public ApplicationResponse<Staff> getStaffById(@PathVariable("id") int id)
	{
		Staff staff = staffService.findStaffById(id);
		ApplicationResponse<Staff> applicationResponse = new ApplicationResponse<Staff>("RECORD IS FOUND",
				HttpStatus.FOUND, LocalDateTime.now(), staff);
		return applicationResponse;
	}
	
	@DeleteMapping("/staff")
	public ApplicationResponse<Staff> removeStaffById(@PathVariable("id") int id)
	{
		staffService.deleteStaffById(id);
		ApplicationResponse<Staff> applicationResponse = new ApplicationResponse<Staff>("RECORD IS DELETED",
				HttpStatus.NO_CONTENT, LocalDateTime.now());
		return applicationResponse;
	}
	
	
}
