package com.servicegenie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Redirects to New registration page 
@Controller
public class RegisterNewUser {
	
	@RequestMapping(value = "/RegisterNewUser" , method = RequestMethod.GET)
	public String RegisterANewUser()
	{
		return "NewRegistration.html";
	}
	
}
