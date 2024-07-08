package com.jsp.Thymeleaf_E_.Commerce_Application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Thymeleaf_E_.Commerce_Application.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	public Optional<Role> findByRoleName(String roleName);
}
