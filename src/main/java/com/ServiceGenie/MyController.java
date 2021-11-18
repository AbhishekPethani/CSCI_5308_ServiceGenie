package com.servicegenie;

import java.sql.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	Connection connect;

	@GetMapping("/hello")
	public String HelloWorld() {
		return "Hello Group 19, Welcome to MACS program , Good MOrning";
	}

	
}
