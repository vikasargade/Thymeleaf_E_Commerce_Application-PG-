package com.jsp.Thymeleaf_E_.Commerce_Application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.jsp.Thymeleaf_E_.Commerce_Application.entity.Amenities;
import com.jsp.Thymeleaf_E_.Commerce_Application.entity.PgDetails;
import com.jsp.Thymeleaf_E_.Commerce_Application.repository.PgRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Service
public class PgService {
	
	@Autowired
	private PgRepository pgRepository;

	public PgDetails addPg(PgDetails pgDetails) {
		return pgRepository.save(pgDetails) ;
	}

	public List<PgDetails> getAll() {
		return pgRepository.findAll();
	}

	
	public List<PgDetails> findByCity(String city) {
		return pgRepository.findByCity(city);
	}

	public List<PgDetails> findByName(String name) {
		return pgRepository.findByPgName(name); 
	}
	
	public PgDetails findById(int id) {
		return pgRepository.findById(id).orElse(null);
	}
   
	public void deletePg(int id)
	{
		pgRepository.deleteById(id);
	}
	
	public PgDetails updatePg(PgDetails pgDetails)
	{
		PgDetails detailsFromDb = pgRepository.findById(pgDetails.getPgId()).orElse(null);
		
		detailsFromDb.setCategory(pgDetails.getCategory());
		detailsFromDb.setNoOfOccupiedRooms(pgDetails.getNoOfOccupiedRooms());
		detailsFromDb.setNoOfRooms(pgDetails.getNoOfRooms());
		detailsFromDb.setPgDeposit(pgDetails.getPgDeposit());
		detailsFromDb.setPgEmail(pgDetails.getPgEmail());
		detailsFromDb.setPgMobile(pgDetails.getPgMobile());
		detailsFromDb.setPgName(pgDetails.getPgName());
		detailsFromDb.setPgRent(pgDetails.getPgRent());
		detailsFromDb.setPgSharing(pgDetails.getPgSharing());
		detailsFromDb.setAddress(pgDetails.getAddress());
		detailsFromDb.setAmenities(pgDetails.getAmenities());
		detailsFromDb.setBookingDetails(pgDetails.getBookingDetails());
		detailsFromDb.setCustomers(pgDetails.getCustomers());
		detailsFromDb.setStaffList(pgDetails.getStaffList());
		
		return pgRepository.save(pgDetails);
	}

	

	public List<PgDetails> getDetailByKeyword(String keyword) { 
		
		List<PgDetails> listOfPg = pgRepository.findAll(keyword);
		
		return listOfPg;
	}
	

}
