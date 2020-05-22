package com.mimaraslan.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mimaraslan.model.User;
import com.mimaraslan.repository.UserRepository;

@RestController
@RequestMapping("api/public")
public class PublicRestApiController {
	
	private UserRepository userRepository;

	public PublicRestApiController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("users")
	public List<User> users() {
		return this.userRepository.findAll();
	}

//----------------------------------------------

	@GetMapping("test1")
	public String test1() {
		return "API Test 1";
	}

	@GetMapping("test2")
	public String test2() {
		return "API Test 2";
	}
}