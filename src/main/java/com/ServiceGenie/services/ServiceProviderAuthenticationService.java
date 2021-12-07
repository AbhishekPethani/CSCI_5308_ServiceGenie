package com.servicegenie.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Service;
import com.servicegenie.ObtainDatabaseConnection;

//Author
//Kandarp Sharad Parikh
//B00873863


@Service
public class ServiceProviderAuthenticationService {
	
	public String validateUser(String userID , String password) throws SQLException
	{
		// Obtain Database connection and get customer details for authentication
		ObtainDatabaseConnection MyDBConnect = new ObtainDatabaseConnection();
		Statement sql = MyDBConnect.GetMyConnection().createStatement();
		ResultSet result = sql.executeQuery("Select * from user_authentication where User_Type='service-provider';");
				
		// Check if userid and password entered matches or not
		// If the userId and password matches the user will be redirected to Customer Home page
		// Else the User will be redirected to Login page again which has an error message
		while(result.next())
		{
			if(result.getString("User_ID").equals(userID) && result.getString("User_Password").equals(password))
			{
				return "ServiceProviderHomePage.html";
			}
		}
		return "LoginFailed.html";
	}
}
