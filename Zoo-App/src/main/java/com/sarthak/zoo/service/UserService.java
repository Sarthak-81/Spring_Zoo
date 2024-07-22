package com.sarthak.zoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarthak.zoo.entity.User;
import com.sarthak.zoo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	 public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }
	    
	    public User getUserById(Long id) {
	        return userRepository.findById(id).orElse(null);
	    }
	    
	    public void deleteAllUsers() {
	    	userRepository.deleteAll();
	    }

	    public void deleteUserById(Long id) {
	        userRepository.deleteById(id);
	    }
	
}
