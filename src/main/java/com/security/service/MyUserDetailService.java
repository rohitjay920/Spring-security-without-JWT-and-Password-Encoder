package com.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.entity.User;
import com.security.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		if(user.isPresent()) {
			var userObj = user.get();
			return org.springframework.security.core.userdetails.User.builder()
					.username(username).password(user.get().getPassword()).roles(getRoles(user)).build();
		}
		else {
			throw new UsernameNotFoundException("User: "+username+" not found");
		}
	}
	
	public String[] getRoles(Optional<User> optional) {
		User user = optional.get();
		String[] arr = {user.getRole().name()};
		return arr;
	}

}
