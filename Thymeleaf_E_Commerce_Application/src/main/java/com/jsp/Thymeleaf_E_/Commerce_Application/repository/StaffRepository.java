package com.jsp.Thymeleaf_E_.Commerce_Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.Thymeleaf_E_.Commerce_Application.entity.Staff;

@Repository
public interface StaffRepository  extends JpaRepository<Staff, Integer>{

	
}
