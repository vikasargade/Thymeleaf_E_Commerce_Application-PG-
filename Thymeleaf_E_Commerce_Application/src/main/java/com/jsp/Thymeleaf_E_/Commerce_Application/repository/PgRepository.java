package com.jsp.Thymeleaf_E_.Commerce_Application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.Thymeleaf_E_.Commerce_Application.entity.PgDetails;

public interface PgRepository extends JpaRepository<PgDetails, Integer> {

	@Query("select p1 from PgDetails p1 where p1.address.city = ?1")
	public List<PgDetails> findByCity(String city);
	
	public List<PgDetails> findByPgName(String pgName);
	
	@Query("SELECT p FROM PgDetails p WHERE  CONCAT "
			+ "(p.pgId,'',p.pgName,'',p.pgSharing,'',p.noOfRooms,'',p.noOfOccupiedRooms,'',p.category,'',p.pgEmail,'',p.pgMobile,'',"
			+ "p.pgDeposit,'',p.pgRent,'',"
			+ "p.customers.customerId,'',p.customers.customerName,'',p.customers.customerEmail,'',p.customers.customerGender,'',p.customers.adharCard,'',"
			+ "p.customers.customerMobile,'',p.customers.customerDate)"
			+ "LIKE CONCAT ('%', ?1, '%')")
	public List<PgDetails> findAll(String keyword); 
	
}
