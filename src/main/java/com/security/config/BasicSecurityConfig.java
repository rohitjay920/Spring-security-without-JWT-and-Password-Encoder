package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
public class BasicSecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(auth -> auth.requestMatchers("/api/message").permitAll()
				.anyRequest().authenticated()).formLogin();
		return http.build();
	}
	
	@Bean
	public UserDetailsManager userDetails() {
		UserDetails user1 = User.withUsername("Rohit").password("{noop}123").roles("ADMIN").build();
		UserDetails user2 = User.withUsername("Sam").password("{noop}12345").roles("USER").build();
		return new InMemoryUserDetailsManager(user1,user2);
	}
}
