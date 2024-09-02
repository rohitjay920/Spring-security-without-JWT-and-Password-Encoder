package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("/api/message")
	public String message() {
		return "Hello!!";
	}
	
	@GetMapping("/api/basic")
	public String basicAuth() {
		return "Hello from basic auth";
	}
}
