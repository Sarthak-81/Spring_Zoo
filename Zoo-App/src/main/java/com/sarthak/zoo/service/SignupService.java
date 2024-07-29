package com.sarthak.zoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sarthak.zoo.dto.SignupRequest;
import com.sarthak.zoo.entity.User;
import com.sarthak.zoo.repository.UserRepository;

@Service
public class SignupService {

	@Autowired
	private User user;
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(SignupRequest signupRequest) {

        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());

        return userRepository.save(user);
    }
	
}
