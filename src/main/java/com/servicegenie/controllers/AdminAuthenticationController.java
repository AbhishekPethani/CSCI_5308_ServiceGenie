//Author
//Kandarp Parikh
//B00873863

package com.servicegenie.controllers;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.servicegenie.services.AdminAuthenticationService;

@Controller
public class AdminAuthenticationController 
{
	@Autowired
	private AdminAuthenticationService AdminAuth; 
		
	// Redirects to Admin Home Page once the credentials of the user have been validated
	@RequestMapping(method = RequestMethod.POST , value = "/admin-authentication")
	public String validateUser(@RequestParam("admin-userid")String myUser , @RequestParam("password") String myPass,ModelMap model) throws SQLException
	{   
		return AdminAuth.validateUser(myUser, myPass, model);
	}
	
	// Internal Redirection to AdminHomePage.html once the user has logged in 
	@RequestMapping(method = RequestMethod.GET , value = "/admin-authentication")
	public String validateUser(ModelMap model) throws SQLException
	{   
		// Adds attributes which will be populated in the admin home page 
		model.addAttribute(AdminAuth.getModelAttributes(model));
		
		return "AdminHomePage.html";
	} 
}
