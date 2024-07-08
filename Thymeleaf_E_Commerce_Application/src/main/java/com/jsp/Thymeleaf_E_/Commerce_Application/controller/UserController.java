package com.jsp.Thymeleaf_E_.Commerce_Application.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Thymeleaf_E_.Commerce_Application.entity.PgDetails;
import com.jsp.Thymeleaf_E_.Commerce_Application.entity.User;
import com.jsp.Thymeleaf_E_.Commerce_Application.response.ApplicationResponse;
import com.jsp.Thymeleaf_E_.Commerce_Application.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	private ApplicationResponse<User> applicationResponse;

	@PostMapping("/users")
	public ApplicationResponse<User> registerUser(@RequestBody User user) {

		User insertedUser = userService.addUser(user);

		if(insertedUser!=null)
		{
			return new ApplicationResponse("USER ADDED SUCCESSFULLY",
					HttpStatus.CREATED, LocalDateTime.now(), insertedUser);
		}
		else
		{
			return new ApplicationResponse("USER  NOT ADDED ",
					HttpStatus.NOT_FOUND, LocalDateTime.now());
		}
		
	}

//	@GetMapping("/users/login/")
//	public ApplicationResponse<User> userLogin(@PathVariable("email") String email,
//			@PathVariable("pass") String password, Model model) {
//		User userLogin = userService.getUserByEmailAndPassword(email, password);
//		ApplicationResponse<User> applicationResponse;
//		if (userLogin != null) {
//			model.addAttribute("success", userLogin);
//			return new ApplicationResponse("LOGIN SUCCESSFUL!", HttpStatus.FOUND, LocalDateTime.now(), userLogin);
//		} else {
//			model.addAttribute("unsuccess", "INVALID CREDENTAILS!");
//			return new ApplicationResponse("LOGIN  UNSUCCESSFUL!", HttpStatus.NOT_FOUND, LocalDateTime.now(),
//					userLogin);
//		}
//
//	}

//	@GetMapping("/users/{id}/{roleName}") // method to add role to user based on id
//	public User getUserById(@PathVariable int id, @PathVariable String roleName) {
//		User user = userService.getUser(id, roleName);
//		return user;
//	}

	@GetMapping("/users")
	public ApplicationResponse<User> getAllUsers() { // to fecth all users

		List<User> listOfUser = userService.findAllUsers();

		if (listOfUser != null) {
			return new ApplicationResponse<User>("RECORDS FOUND", HttpStatus.FOUND, LocalDateTime.now(), listOfUser);
		}

		else
		{
			return new ApplicationResponse<User>("RECORDS NOT FOUND", HttpStatus.FOUND, LocalDateTime.now());
		}
	}

	@GetMapping("/users/{id}")
	public ApplicationResponse<User> getUserById(@PathVariable int id) { // to get user by id
		User user = userService.findUserById(id);

		if (user != null)
			return new ApplicationResponse("USER FOUND", HttpStatus.FOUND, LocalDateTime.now(), user);

		else
			return new ApplicationResponse("USER NOT FOUND", HttpStatus.NOT_FOUND, LocalDateTime.now());
	}

	@GetMapping("/users/{email}/{pass}")
	public ApplicationResponse<User> getUserByEmailAndPass(@PathVariable String email, @PathVariable String pass) {
		User user = userService.getUserByEmailAndPassword(email, pass);

		if(user!=null)
		{
			return new ApplicationResponse<User>("RECORD FOUND", HttpStatus.FOUND,
					LocalDateTime.now(), user);
		}
		else
		{
			return new ApplicationResponse<User>("RECORD NOT FOUND", HttpStatus.FOUND,
					LocalDateTime.now());
		}
	}

	@PutMapping("/users")
	public ApplicationResponse<User> updateUserById(@RequestBody User user) { // to update the user's information
		User updatedUser = userService.updateUserById(user);

		if (updatedUser != null) {
			return new ApplicationResponse<User>("USER UPDATED SUCCESSFULLY", HttpStatus.ACCEPTED, LocalDateTime.now(),
					updatedUser);

		} else {
			return new ApplicationResponse<User>("USER NOT UPDATED ", HttpStatus.NOT_MODIFIED, LocalDateTime.now());
		}
	}

	@DeleteMapping("/users/{id}")
	public ApplicationResponse<User> deleteUserById(@PathVariable("id") int id) {

		userService.deleteUserById(id);
		return new ApplicationResponse<User>("RECORD DELETED", HttpStatus.NO_CONTENT, LocalDateTime.now()); // enum for
																											// delete
	}

}
