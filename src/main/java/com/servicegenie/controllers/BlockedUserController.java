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
import org.springframework.web.servlet.ModelAndView;

import com.servicegenie.services.BlockedUserService;

@Controller
public class BlockedUserController 
{	
	@Autowired
	private BlockedUserService user;
		
	// Redirects to Blocked users page 
	@RequestMapping(method = RequestMethod.GET , value = "/BlockUsers")
	public String getBlockedUsersPage(ModelMap model) throws SQLException
	{   
		model.addAttribute("blockedUsers", user.getBlockedUserDetails());
		model.addAttribute("serviceProviders", user.getAllServiceProvidersID());
		model.addAttribute("customers", user.getAllCustomersID());
		return "BlockedUsers.html";
	}
	
	// Redirects to Blocked Users page and shows information of blocked Service Providers
	@RequestMapping(method = RequestMethod.POST , value = "/ViewBlockedServiceProvider")
	public ModelAndView getBlockedServiceProviders(ModelMap model , ModelAndView modelView) throws SQLException
	{   
		modelView.setViewName("BlockedUsers.html");
		modelView.addObject("serviceProviders", user.getAllServiceProvidersID());
		modelView.addObject("customers", user.getAllCustomersID());
		modelView.addObject("blockedUsers", user.getBlockedUserDetails());
		modelView.addObject("blockedUsers", user.getBlockedServiceProvidersDetails());
		return modelView;
	}

	// Redirects to Blocked Users page and shows information of blocked customers
	@RequestMapping(method = RequestMethod.POST , value = "/ViewBlockedCustomer")
	public ModelAndView getBlockedCustomers(ModelAndView modelView) throws SQLException
	{   
		modelView.setViewName("BlockedUsers.html");
		modelView.addObject("serviceProviders", user.getAllServiceProvidersID());
		modelView.addObject("customers", user.getAllCustomersID());
		modelView.addObject("blockedUsers", user.getBlockedUserDetails());
		modelView.addObject("blockedUsers", user.getBlockedCustomersDetails());
		return modelView;
	}
	
	// Redirects to Blocked Users page and blocks the selected user from the dropdown menu
	@RequestMapping(method = RequestMethod.POST , value = "/BlockUser")
	public ModelAndView blockUser(@RequestParam("User_ID")String User_ID ,ModelAndView modelView) throws SQLException
	{   
		modelView.setViewName("BlockedUsers.html");
		user.blockUser(User_ID.substring(1));
		modelView.addObject("blockedUsers", user.getBlockedUserDetails());
		modelView.addObject("serviceProviders", user.getAllServiceProvidersID());
		modelView.addObject("customers", user.getAllCustomersID());
		return modelView;
	}
	
	// Redirects to Blocked Users page and unblocks the selected user from the dropdown menu
	@RequestMapping(method = RequestMethod.POST , value = "/UnblockUser")
	public ModelAndView unblockUser(@RequestParam("User_ID")String User_ID ,ModelAndView modelView) throws SQLException
	{   
		modelView.setViewName("BlockedUsers.html");
		user.unblockUser(User_ID.substring(1));
		modelView.addObject("customers", user.getAllBlockedCustomersID());
		modelView.addObject("serviceProviders", user.getAllBlockedServiceProvidersID());
		modelView.addObject("blockedUsers", user.getBlockedUserDetails());
		return modelView;
	}
}
