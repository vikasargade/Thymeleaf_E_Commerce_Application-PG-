package com.jsp.Thymeleaf_E_.Commerce_Application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.Thymeleaf_E_.Commerce_Application.entity.Amenities;
import com.jsp.Thymeleaf_E_.Commerce_Application.entity.PgDetails;
import com.jsp.Thymeleaf_E_.Commerce_Application.entity.Staff;
import com.jsp.Thymeleaf_E_.Commerce_Application.repository.PgRepository;
import com.jsp.Thymeleaf_E_.Commerce_Application.repository.AmenitiesRepository;

@Service
public class AmenitiesService {

	@Autowired
	private AmenitiesRepository amenitiesRepository;

	@Autowired
	private PgRepository pgRepository;

	public Amenities getAmenitiesById(int aId) {

		return amenitiesRepository.findById(aId).orElse(null);
	}

	public PgDetails addAmenitiesToPg(int pId, Amenities amenities) {
		PgDetails pgDetailsFromDB = pgRepository.findById(pId).orElse(null);

		if (pgDetailsFromDB != null) {

			List<PgDetails> list = List.of(pgDetailsFromDB);
			amenities.setPgDetails(list);

			Amenities amenitiesFromDB = addAmenities(amenities);

		} else
			return null;

		return pgDetailsFromDB;

	}

	private Amenities addAmenities(Amenities amenities) {

		return amenitiesRepository.save(amenities);
	}

}
