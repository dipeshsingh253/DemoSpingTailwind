package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.UserException;
import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) throws UserException {

		User existedUser = userRepository.findByEmail(user.getEmail());

		if (existedUser != null) {
			throw new UserException("User already exists with given email");
		}

		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) throws UserException {

		Optional<User> optional = userRepository.findById(user.getUserId());

		if (optional.isEmpty()) {
			throw new UserException("User does not exists. Enter valid details...!");
		}

		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() throws UserException {
		
		List<User> users = userRepository.findAll();
		
		if(users.size()==0) {
			throw new UserException("No Users Exists");
		}
		
		
		return users;
	}

}
