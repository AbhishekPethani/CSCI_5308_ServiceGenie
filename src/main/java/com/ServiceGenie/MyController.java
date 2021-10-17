package com.ServiceGenie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/hello")
	public String HelloWorld() {
		return "Hello Group 19, Welcome to MACS program";
	}

}
