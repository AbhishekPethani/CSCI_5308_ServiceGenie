package com.servicegenie.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.servicegenie.services.CustomerAuthenticationService;


// Class for Authenticating Customer credentials at the time of login
@Controller
public class CustomerAuthenticationController {
	
	@Autowired
	private CustomerAuthenticationService customerauthenticationservice;

	@RequestMapping(method = RequestMethod.POST , value = "/customer-authentication")
	public String ValidateUser(@RequestParam("customer-userid")String myUser , @RequestParam("customer-password") String myPass) throws SQLException
	{
		return customerauthenticationservice.ValidateUser(myUser, myPass);
	}
}
