package com.jsp.Thymeleaf_E_.Commerce_Application.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	private ApplicationResponse<Staff> applicationResponse;

	@PostMapping("/staff/{pgId}")
	public ApplicationResponse<PgDetails> addStaff(@RequestBody Staff staff, @PathVariable("pgId") int pgId) {
		PgDetails pgWithStaff = staffService.addStaffToPg(pgId, staff);

		if (pgWithStaff != null) {
			ApplicationResponse<PgDetails> applicationResponsepg = new ApplicationResponse<PgDetails>(
					"STAFF DETAILS IS UPDATED TO PG", HttpStatus.ACCEPTED, LocalDateTime.now(), pgWithStaff);
			return applicationResponsepg;
		} else {
			ApplicationResponse<PgDetails> applicationResponsepg = new ApplicationResponse<PgDetails>(
					"STAFF DETAILS IS  NOT UPDATED TO PG", HttpStatus.NOT_FOUND, LocalDateTime.now());
			return applicationResponsepg;
		}

	}

	@GetMapping("/staff")
	public ApplicationResponse<Staff> getAllStaff() {
		List<Staff> listOfStaff = staffService.findAllStaff();

		if (listOfStaff != null) {
			return new ApplicationResponse<Staff>("RECORDS ARE FOUND", HttpStatus.FOUND, LocalDateTime.now(),
					listOfStaff);

		} else {
			return new ApplicationResponse<Staff>("RECORDS ARE NOT FOUND", HttpStatus.FOUND, LocalDateTime.now());

		}

	}

	@GetMapping("/staff/{id}")
	public ApplicationResponse<Staff> getStaffById(@PathVariable("id") int id) {

		Staff staff = staffService.findStaffById(id);
		if (staff != null) {
			return new ApplicationResponse<Staff>("RECORD FOUND", HttpStatus.FOUND, LocalDateTime.now(), staff);

		} else {
			return new ApplicationResponse<Staff>("RECORD  NOT FOUND", HttpStatus.FOUND, LocalDateTime.now());

		}

	}

	@DeleteMapping("/staff/{id}") 
	public ApplicationResponse<Staff> removeStaffById(@PathVariable("id") int id) {
		staffService.deleteStaffById(id);
		return new ApplicationResponse<Staff>("RECORD IS DELETED", HttpStatus.NO_CONTENT, LocalDateTime.now());
	}

	@PutMapping("/staff/{id}")
	public ApplicationResponse<Staff> updateStaffDetailsById(@RequestBody() Staff staff, @PathVariable("id") int id) {
		Staff updatedDetails = staffService.updateStaffById(staff, id);

		if (updatedDetails != null) {
			return new ApplicationResponse<Staff>("STAFF DETAILS IS UPDATED", HttpStatus.ACCEPTED, LocalDateTime.now(),
					updatedDetails);

		} else {
			return new ApplicationResponse<Staff>("STAFF DETAILS IS  NOT UPDATED", HttpStatus.NOT_MODIFIED,
					LocalDateTime.now());

		}
	}

}
