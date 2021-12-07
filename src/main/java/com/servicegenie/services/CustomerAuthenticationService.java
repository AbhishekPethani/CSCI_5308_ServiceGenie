//Author
//Kandarp Parikh
//B00873863

package com.servicegenie.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.servicegenie.daos.CustomerAuthenticationDao;


// Class for Authenticating Customer credentials at the time of login
@Service
public class CustomerAuthenticationService 
{
	private CustomerAuthenticationDao customer;
	
	
	public CustomerAuthenticationService() throws SQLException
	{
		CustomerAuthenticationDao customer = new CustomerAuthenticationDao();
		this.customer = customer;
	}

	public boolean validateUser(String myUser ,String myPass) throws SQLException
	{
		ResultSet result= customer.validateUser(myUser, myPass);
		// Check if userid and password entered matches or not
		// If the userId and password matches the user will be redirected to Customer Home page
		// Else the User will be redirected to Login page again which has an error message
		while(result.next())
		{
			if(result.getString("User_ID").equals(myUser) && result.getString("User_Password").equals(myPass))
			{
				
				return true;
			}
		}
		return false;
	}
}
