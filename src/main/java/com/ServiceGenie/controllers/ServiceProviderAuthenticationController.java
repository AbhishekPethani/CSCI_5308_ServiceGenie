package com.servicegenie.controllers;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.servicegenie.services.ServiceProviderAuthenticationService;

@Controller
public class ServiceProviderAuthenticationController {
	
	@Autowired
	private ServiceProviderAuthenticationService serviceproviderauthentication;
	@RequestMapping(method = RequestMethod.POST , value = "/service-provider-authentication")
	public String ValidateUser(@RequestParam("service-provider-userid")String userID, @RequestParam("password") String password) throws SQLException
	{
		return serviceproviderauthentication.ValidateUser(userID, password);
	}
}
