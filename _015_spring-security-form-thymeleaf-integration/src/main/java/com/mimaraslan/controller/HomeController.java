package com.mimaraslan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class HomeController {

	@GetMapping("index")
	public String index() {
		return "index";
	}

	@GetMapping("login")
	public String login() {
		return "login";
	}
}