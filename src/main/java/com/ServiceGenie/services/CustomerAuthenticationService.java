package com.servicegenie.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Service;

import com.servicegenie.daos.AuthenticationDao;

//Author
//Kandarp Sharad Parikh
//B00873863

// Class for Authenticating Customer credentials at the time of login
@Service
public class CustomerAuthenticationService {

	public String validateUser(String myUser ,String myPass) throws SQLException
	{
		//Get the results from DAO
		AuthenticationDao authenticate = new AuthenticationDao();
		ResultSet result = authenticate.getCustomerCredentials();
		
		// Check if userid and password entered matches or not
		// If the userId and password matches the user will be redirected to Customer Home page
		// Else the User will be redirected to Login page again which has an error message
		while(result.next())
		{
			if(result.getString("User_ID").equals(myUser) && result.getString("User_Password").equals(myPass))
			{
				return "UserHomePage.html";
			}
		}
		return "LoginFailed.html";
	}
}
