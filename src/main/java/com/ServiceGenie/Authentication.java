package com.servicegenie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


// Class for Authenticating Customer credentials at the time of login
@Controller
public class Authentication {

	@RequestMapping(method = RequestMethod.POST , value = "/customer-authentication")
	public String ValidateUser(@RequestParam("customer-userid")String MyUser , @RequestParam("customer-password") String MyPass) throws SQLException
	{
		
		// Obtain Database connection and get customer details for authentication
		ObtainDatabaseConnection MyDBConnect = new ObtainDatabaseConnection();
		Statement sql = MyDBConnect.GetMyConnection().createStatement();
		ResultSet result = sql.executeQuery("Select * from user_authentication where User_Type='customer';");
		
		// Check if userid and password entered matches or not
		// If the userId and password matches the user will be redirected to Customer Home page
		// Else the User will be redirected to Login page again which has an error message
		while(result.next())
		{
			if(result.getString("User_ID").equals(MyUser) && result.getString("User_Password").equals(MyPass))
			{
				return "redirect:UserHomePage.html";
			}
		}
		return "redirect:LoginFailed.html";
	}
}
