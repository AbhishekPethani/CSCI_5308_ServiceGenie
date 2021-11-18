package com.servicegenie.controllers;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.servicegenie.services.CheckUserExistenceService;
import com.servicegenie.services.ObtainDatabaseConnectionService;

//Class to register a new user as a customer
@Controller
public class RegisterAsCustomerController {

	public String RegisterAsACustomer(String userId,String password) throws SQLException
	{
		
		// Creating instance of CheckUserExistence class to verify if the user of type customer is already present or not
		// If the UserId is present in database, the user is redirected to Registration page with Error message
		// Else the a new user is registered with customer type
		CheckUserExistenceService validation = new CheckUserExistenceService();
		if(validation.CheckDatabase(userId,"customer") == true)
		{
			return "redirect:RegistrationFailed.html";
		}
		ObtainDatabaseConnectionService dbconnect = new ObtainDatabaseConnectionService();
	      String query = " insert into user_authentication (User_Id, User_Password, User_Type)"
	    	        + " values (?, ?, ?)";
	      
	      PreparedStatement MyPreparedStatement = dbconnect.GetMyConnection().prepareStatement(query);
	      MyPreparedStatement.setString (1, userId);
	      MyPreparedStatement.setString (2, password);
	      MyPreparedStatement.setString (3, "customer");
	      MyPreparedStatement.execute();
	      
		  return "redirect:SuccessfulRegistration.html";
	}
	
}

