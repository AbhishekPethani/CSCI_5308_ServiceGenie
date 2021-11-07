package com.servicegenie.controllers;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.servicegenie.services.RegisterAsCustomerService;
import com.servicegenie.services.RegisterAsServiceProviderService;

//Class to register a new user as a service-provider
@Controller
public class RegisterAsServiceProviderController {
	
	@Autowired
	private RegisterAsServiceProviderService registerasserviceprovider;
	
	@RequestMapping(value = "/RegisterAsServiceProvider", method = RequestMethod.POST)
	public String RegisterAsAServiceProvider(@RequestParam("service-provider-userid") String userId, @RequestParam("service-provider-password")String password) throws SQLException
	{
		return registerasserviceprovider.RegisterAsAServiceProvider(userId, password);
	}

}
