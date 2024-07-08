package com.jsp.Thymeleaf_E_.Commerce_Application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Thymeleaf_E_.Commerce_Application.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public Optional<User> findByEmailAndPassword(String email, String password);
 
}
