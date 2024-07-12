package com.sarthak.zoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarthak.zoo.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;
	
	public boolean authenticate(String name, String password)
	{
		return userRepository.findByNameAndPassword(name, password)!=null;
	}
	
}
