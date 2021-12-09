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

import com.servicegenie.services.ServiceProviderAuthenticationService;

@Controller
public class ServiceProviderAuthenticationController 
{
	@Autowired
	private ServiceProviderAuthenticationService serviceproviderauthentication;
	
	//Controller to handle the authentication of service provider
	@RequestMapping(method = RequestMethod.POST , value = "/service-provider-authentication")
	public String ValidateUser(@RequestParam("service-provider-userid")String userID, @RequestParam("password") String password) throws SQLException
	{
		return serviceproviderauthentication.validateUser(userID, password);
	}
}
