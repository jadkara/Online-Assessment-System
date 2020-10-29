package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.model.User;
import com.wipro.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void addUser(User user)
	{
		userRepository.save(user);
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}
}
