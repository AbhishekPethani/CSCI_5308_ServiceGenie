package com.servicegenie;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//Class to register a new user as a customer
@Controller
public class RegisterAsCustomer {
	
	@RequestMapping(value = "/RegisterAsCustomer", method = RequestMethod.POST)
	public String RegisterAsACustomer(@RequestParam("customer-userid") String UserId, @RequestParam("customer-password")String Password) throws SQLException
	{
		
		// Creating instance of CheckUserExistence class to verify if the user of type customer is already present or not
		// If the UserId is present in database, the user is redirected to Registration page with Error message
		// Else the a new user is registered with customer type
		CheckUserExistence validation = new CheckUserExistence();
		if(validation.CheckDatabase(UserId,"customer") == true)
		{
			return "redirect:RegistrationFailed.html";
		}
		ObtainDatabaseConnection dbconnect = new ObtainDatabaseConnection();
	      String query = " insert into user_authentication (User_Id, User_Password, User_Type)"
	    	        + " values (?, ?, ?)";
	      
	      PreparedStatement MyPreparedStatement = dbconnect.GetMyConnection().prepareStatement(query);
	      MyPreparedStatement.setString (1, UserId);
	      MyPreparedStatement.setString (2, Password);
	      MyPreparedStatement.setString (3, "customer");
	      MyPreparedStatement.execute();
	      
		  return "redirect:SuccessfulRegistration.html";
	}
	
}
