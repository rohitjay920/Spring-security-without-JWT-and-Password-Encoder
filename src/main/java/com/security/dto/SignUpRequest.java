package com.security.dto;

import com.securityenum.Roles;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUpRequest {
	private String username;
	private String email;
	private String password;
	private Roles role; 
}
