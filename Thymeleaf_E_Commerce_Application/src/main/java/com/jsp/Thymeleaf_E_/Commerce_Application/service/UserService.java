package com.jsp.Thymeleaf_E_.Commerce_Application.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.Thymeleaf_E_.Commerce_Application.entity.Role;
import com.jsp.Thymeleaf_E_.Commerce_Application.entity.User;
import com.jsp.Thymeleaf_E_.Commerce_Application.repository.RoleRepository;
import com.jsp.Thymeleaf_E_.Commerce_Application.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public User addUser(User user) {

		return userRepository.save(user);

	}

	public User getUser(int id, String roleName) {

		User user = userRepository.findById(id).orElse(null);
		Role role = roleRepository.findByRoleName(roleName).orElse(null);
		user.setRoles(Set.of(role));
		userRepository.save(user);
		return user;

	}

	public List<User> findAllUsers() {

		return userRepository.findAll();

	}

	public User findUserById(int id) {

		return userRepository.findById(id).orElse(null);
	}

	public void deleteUserById(int id) {
		userRepository.deleteById(id);

	}

	
	public User updateUserById(User user) {

		User userFromDb = userRepository.findById(user.getUserId()).orElse(null);
		
		userFromDb.setEmail(user.getEmail());
		userFromDb.setFname(user.getFname());
		userFromDb.setGender(user.getGender());
		userFromDb.setLname(user.getLname());
		userFromDb.setMobile(user.getMobile());
		userFromDb.setPassword(user.getPassword());
		User updatedUser = userRepository.save(userFromDb);
		return updatedUser;
	}

	public User getUserByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password).orElse(null);

	}
	
	
}
