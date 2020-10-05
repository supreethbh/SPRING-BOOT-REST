package com.dxc.spring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.spring.user.model.UserDetails;
import com.dxc.spring.user.service.IUserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private IUserService service;

	@PostMapping(path = "/insert", consumes = { "application/json" })
	public UserDetails insertUserDetails(@RequestBody UserDetails userDetails) {
		return service.insertUserDetails(userDetails);
	}

	@PutMapping(path = "/update/{userId}", consumes = { "application/json" })
	public UserDetails updateUserDetails(@RequestBody UserDetails userDetails, @PathVariable("userId") long userId) {
		return service.updateUserDetails(userDetails, userId);
	}

	@GetMapping(path = "/getUser/{userId}", produces = { "application/json" })
	public UserDetails getUserById(@PathVariable("userId") long userId) {
		return service.getUserById(userId);
	}

	@DeleteMapping(path = "/delete/{userId}")
	public ResponseEntity<?> deleteUserById(@PathVariable("userId") long userId) {
		return service.deleteUserById(userId);
	}

	@GetMapping(path = "/getAllUsers", produces = { "application/json" })
	public List<UserDetails> getAllUserDetails() {
		return service.getAllUserDetails();
	}

}
