package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	
	@GetMapping("/hi")
	//@RequestMapping(path="/hi", method=RequestMethod.GET)
	public String hello() {
		return "hi!";
	}
}