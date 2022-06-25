package com.hubert.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	/*
	 * services without Security 
	  /whyus - this will display the testimonials for those who avail the product
	  
	  
	  SERVICES WITH SECURITY
	  /books
	  /courses
	  /freebies
	  
	 */	
	
	
	
	
	@GetMapping("/whyus")
	public String login() {
		return "Why us Page";
	}
	

	@GetMapping("/")
	public String home(Authentication auth) {
	
		return "Welcome Home " + auth.getName().toUpperCase() + " role: " + auth.getAuthorities().toString();
	}
}
