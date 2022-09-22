package com.project1.questapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.questapp.entities.User;
import com.project1.questapp.repos.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}


	public User saveOneUser(User newUser) {
		return userRepository.save(newUser);
	}

	public User getOneUserById(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public User updateOneUser(Long userId, User newUser) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setuserName(newUser.getuserName());
			foundUser.setPassword(newUser.getPassword());
			
			userRepository.save(foundUser);
			return foundUser;
		}else
			return null;
	}

	public void deleteById(Long userId) {
		userRepository.deleteById(userId);	
	}
	
}
