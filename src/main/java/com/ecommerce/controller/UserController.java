package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.UserException;
import com.ecommerce.model.User;
import com.ecommerce.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws UserException {

		User saved = userService.addUser(user);

		return new ResponseEntity<User>(saved, HttpStatus.ACCEPTED);
	}

	@PutMapping("/updateuser")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws UserException {

		User updated = userService.updateUser(user);

		return new ResponseEntity<User>(updated, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getusers")
	public ResponseEntity<List<User>> showAllUsers() throws UserException {

		List<User> users = userService.getAllUsers();

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);

	}

}
