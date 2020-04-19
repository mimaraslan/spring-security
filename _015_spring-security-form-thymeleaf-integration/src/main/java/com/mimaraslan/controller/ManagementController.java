package com.mimaraslan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("management")
@Controller
public class ManagementController {

	@GetMapping("index")
	public String index() {
		return "management/index";
	}
}