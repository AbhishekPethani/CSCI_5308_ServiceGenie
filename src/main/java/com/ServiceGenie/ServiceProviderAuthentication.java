package com.servicegenie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ServiceProviderAuthentication {
	@RequestMapping(method = RequestMethod.POST , value = "/service-provider-authentication")
	public String ValidateUser(@RequestParam("service-provider-userid")String MyUser , @RequestParam("password") String MyPass) throws SQLException
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
			if(result.getString("User_ID").equals(MyUser) && result.getString("User_Password").equals(MyPass))
			{
				return "redirect:ServiceProviderHomePage.html";
			}
		}
		return "redirect:LoginFailed.html";
	}
}
