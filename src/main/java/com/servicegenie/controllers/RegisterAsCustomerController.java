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

import com.servicegenie.services.CheckUserExistenceService;
import com.servicegenie.services.RegisterAsCustomerService;

//Class to register a new user as a customer
@Controller
public class RegisterAsCustomerController {
	
	@Autowired
	private RegisterAsCustomerService customer;
	
	@RequestMapping(value = "/RegisterAsCustomer", method = RequestMethod.POST)
	public String registerAsACustomer(@RequestParam("customer-userid") String userId, @RequestParam("customer-password")String password) throws SQLException
	{
		// Creating instance of CheckUserExistence class to verify if the user of type customer is already present or not
		// If the UserId is present in database, the user is redirected to Registration page with Error message
		// Else the a new user is registered with customer type
		CheckUserExistenceService validation = new CheckUserExistenceService();
		if(validation.checkDatabase(userId,"customer") == true)
		{
			return "RegistrationFailed.html";
		}
		else
		{
			customer.registerCustomer(userId, password);
			return "SuccessfulRegistration.html";
		}
	}
	
}

