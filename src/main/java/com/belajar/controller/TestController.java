package com.belajar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/")
	public String Test() {
		return "Spring Boot is Working";
	}
}
