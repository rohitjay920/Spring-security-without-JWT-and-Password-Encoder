package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.security.service.MyUserDetailService;



@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	@Autowired
	private MyUserDetailService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		UserDetails userDetails = userService.loadUserByUsername(username);
		System.err.println(password+"         "+userDetails.getPassword());
		System.err.println(password.equals(userDetails.getPassword()));
		if(!userDetails.getPassword().equals(password)) {
			throw new BadCredentialsException("Invalid username or password");
		}
		return new UsernamePasswordAuthenticationToken(username, password,userDetails.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
