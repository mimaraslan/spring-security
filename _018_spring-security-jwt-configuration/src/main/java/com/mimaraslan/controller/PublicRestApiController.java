package com.mimaraslan.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mimaraslan.model.User;
import com.mimaraslan.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("api/public")
@CrossOrigin
public class PublicRestApiController {
	private UserRepository userRepository;

	public PublicRestApiController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// Available to all authenticated users
	@GetMapping("test")
	public String test1() {
		return "API Test";
	}

	// Available to managers
	@GetMapping("management/reports")
	public String reports() {
		return "Some report data";
	}
	
	
	/*
	 
	 https://localhost:8443/login
	 
	 	{
			"username":"admin",
			"password":"admin"
		}


	 

	 https://localhost:8443/api/public/admin/users
	 
	 Bearer 
	 eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.
	 eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU4NTU4MjIyNH0.
	 cUqtvx5p5nNfjWt_MNxgde1iWOFaiTyBrAgbgFYm4HXYZC-QA8hVhZW4w_zd6t3U6Isua9FqA_O77AihpQFJgA
	 
	*/
	
	// Available to ROLE_ADMIN
	@GetMapping("admin/users")
	public List<User> users() {
		return this.userRepository.findAll();
	}
}