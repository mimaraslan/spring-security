package com.mimaraslan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mimaraslan.model.User;
import com.mimaraslan.repository.UserRepository;

import java.util.List;

@RequestMapping("api/public")
@RestController
public class PublicRestApiController {
	private UserRepository userRepository;

	public PublicRestApiController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("test1")
	public String test1() {
		return "API Test 1";
	}

	@GetMapping("test2")
	public String test2() {
		return "API Test 2";
	}

	// http://localhost:8080/api/public/users
	@GetMapping("users")
	public List<User> users() {
		return this.userRepository.findAll();
	}
}