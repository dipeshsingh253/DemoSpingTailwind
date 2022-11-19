package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.UserException;
import com.ecommerce.model.User;

public interface UserService {

	public User addUser(User user) throws UserException;
	
	public User updateUser(User user) throws UserException;
	
	public List<User> getAllUsers() throws UserException;
	
}
