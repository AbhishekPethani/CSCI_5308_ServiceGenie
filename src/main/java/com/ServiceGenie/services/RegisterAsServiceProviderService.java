package com.servicegenie.services;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//Class to register a new user as a service-provider
@Service
public class RegisterAsServiceProviderService {
	
	
	public String RegisterAsAServiceProvider(String userId, String password) throws SQLException
	{
		// Creating instance of CheckUserExistence class to verify if the user of type service-provider is already present or not
		// If the UserId is present in database, the user is redirected to Registration page with Error message
		// Else the a new user is registered with service-provider type
		
		CheckUserExistenceService validation = new CheckUserExistenceService();
		if(validation.CheckDatabase(userId,"service-provider") == true)
		{
			return "redirect:RegistrationFailed.html";
		}
		ObtainDatabaseConnectionService dbconnect = new ObtainDatabaseConnectionService();
		
		String query = " insert into user_authentication (User_Id, User_Password, User_Type)"
			    	        + " values (?, ?, ?)";
		
		PreparedStatement MyPreparedStatement = dbconnect.GetMyConnection().prepareStatement(query);
	    MyPreparedStatement.setString (1, userId);
	    MyPreparedStatement.setString (2, password);
	    MyPreparedStatement.setString (3, "service-provider");
	    MyPreparedStatement.execute();
		
		return "redirect:SuccessfulRegistration.html";
		
	}

}
