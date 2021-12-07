//Author
//Kandarp Sharad Parikh
//B00873863

package com.servicegenie.controllers;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.servicegenie.services.CustomerAuthenticationService;


// Class for Authenticating Customer credentials at the time of login
@Controller
public class CustomerAuthenticationController {
	
	@Autowired
	private CustomerAuthenticationService customerauthenticationservice;

	// Method to redirect to user home page if the credentials are correct
	// Else the user will be redirected to login page with error message
	@RequestMapping(method = RequestMethod.POST , value = "/customer-authentication")
	public String validateUser(@RequestParam("customer-userid")String myUser , @RequestParam("customer-password") String myPass) throws SQLException
	{
		if(customerauthenticationservice.validateUser(myUser, myPass) == true)
		{
			return "UserHomePage.html";
		}
		else
		{
			return "LoginFailed.html";
		}
	}
}
