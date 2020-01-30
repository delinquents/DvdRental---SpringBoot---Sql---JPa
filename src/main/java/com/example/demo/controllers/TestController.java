package com.example.demo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	
	  @GetMapping("/dvd-rental/auth/user")
	  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	  public String userAccess() {
	    return ">>> User Contents!";
	  }
	  
	  @GetMapping("/dvd-rental/auth/pm")
	  @PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
	  public String projectManagementAccess() {
	    return ">>> Board Management Project";
	  }
	  
	  @GetMapping("/dvd-rental/auth/admin")
	  @PreAuthorize("hasRole('ADMIN')")
	  public String adminAccess() {
	    return ">>> Admin Contents";
	  }
}

