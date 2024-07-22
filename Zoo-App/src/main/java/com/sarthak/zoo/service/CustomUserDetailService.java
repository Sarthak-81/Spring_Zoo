package com.sarthak.zoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.sarthak.zoo.entity.User;
import com.sarthak.zoo.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService 
{

	 @Autowired
	    private UserRepository userRepo;

	    @Override
	    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
	        User user = userRepo.findByName(name);
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found");
	        }
	        return org.springframework.security.core.userdetails.User.builder()
	            .username(user.getName())
	            .password("{noop}" + user.getPassword())
	            .roles(user.getRole())
	            .build();
	    }
}
