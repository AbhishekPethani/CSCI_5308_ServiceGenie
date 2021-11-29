package com.servicegenie.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Service;

@Service
public class AdminAuthenticationService {
	
	public String ValidateUser(String myUser , String myPass) throws SQLException
	{
		
		// Obtain Database connection and get customer details for authentication
		ObtainDatabaseConnectionService MyDBConnect = new ObtainDatabaseConnectionService();
		Statement sql = MyDBConnect.GetMyConnection().createStatement();
		ResultSet result = sql.executeQuery("Select * from user_authentication where User_Type='admin';");
		
		// Check if userid and password entered matches or not
		// If the userId and password matches the user will be redirected to Customer Home page
		// Else the User will be redirected to Login page again which has an error message
		while(result.next())
		{
			if(result.getString("User_ID").equals(myUser) && result.getString("User_Password").equals(myPass))
			{
				return "redirect:AdminHomePage.html";
			}
		}
		return "redirect:LoginFailed.html";
	}

}
