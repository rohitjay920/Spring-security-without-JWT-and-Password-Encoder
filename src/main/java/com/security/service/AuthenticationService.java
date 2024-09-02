package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.dto.SignUpRequest;
import com.security.entity.User;
import com.security.repository.UserRepository;

@Service
public class AuthenticationService {
	
	@Autowired
	private UserRepository userRepository;
	
	public String signUp(SignUpRequest signUpRequest) {
		User user = new User();
		user.setEmail(signUpRequest.getEmail());
		user.setRole(signUpRequest.getRole());
		user.setPassword(signUpRequest.getPassword());
		user.setUsername(signUpRequest.getUsername());
		
		userRepository.save(user);
		return "User has been successfully created";
	}
}
