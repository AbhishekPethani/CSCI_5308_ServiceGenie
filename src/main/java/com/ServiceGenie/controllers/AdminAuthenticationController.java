package com.servicegenie.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.servicegenie.services.AdminAuthenticationService;

@Controller
public class AdminAuthenticationController {
	
	@Autowired
	private AdminAuthenticationService AdminAuth;
		
	@RequestMapping(method = RequestMethod.POST , value = "/admin-authentication")
	public String ValidateUser(@RequestParam("admin-userid")String myUser , @RequestParam("password") String myPass) throws SQLException
	{
		return AdminAuth.ValidateUser(myUser, myPass);

	}
}
