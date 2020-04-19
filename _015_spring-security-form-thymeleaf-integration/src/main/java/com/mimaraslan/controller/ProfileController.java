package com.mimaraslan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("profile")
@Controller
public class ProfileController {

	@GetMapping("index")
	public String index() {
		return "profile/index";
	}
}