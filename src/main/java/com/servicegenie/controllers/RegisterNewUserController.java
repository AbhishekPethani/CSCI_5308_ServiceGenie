//Author
//Kandarp Sharad Parikh
//B00873863

package com.servicegenie.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Redirects to New registration page 
@Controller
public class RegisterNewUserController {
	
	// controller to redirect to registration page
	@RequestMapping(value = "/RegisterNewUser" , method = RequestMethod.GET)
	public String RegisterANewUser()
	{
		return "NewRegistration.html";
	}
	
}
