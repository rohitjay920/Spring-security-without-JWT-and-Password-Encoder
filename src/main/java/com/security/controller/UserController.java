package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.dto.SignUpRequest;
import com.security.repository.UserRepository;
import com.security.service.AuthenticationService;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/signUp")
	public ResponseEntity<String> signUp(@RequestBody SignUpRequest signUpRequest){
		String message = authenticationService.signUp(signUpRequest);
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	@GetMapping("/login")
	public ResponseEntity<String> signIn() {
		return new ResponseEntity<String>("Login successful user",HttpStatus.OK);
	}
}
