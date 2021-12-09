package com.servicegenie.controllers;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.servicegenie.model.ServiceProviderProfile;
import com.servicegenie.services.ServiceProviderProfileService;

//author
//Abhishek Pareshbhai Pethani
//B00899521

@Controller
public class ServiceProviderProfileController {
	
	// Object of ServiceProviderProfileService service class
	@Autowired
	public ServiceProviderProfileService serviceProviderProfileService;
	
	// Controller for handling service provider profile request
	@RequestMapping(method = RequestMethod.GET , value = "/my-profile/{service-provider-userid}")
	public ModelAndView getServiceProviderProfile(@PathVariable("service-provider-userid")String userID) throws SQLException {
		// create object of ModelAndView
		ModelAndView mv = new ModelAndView();
		
		// set the name of returning view 
		mv.setViewName("ServiceProviderProfile.html");
		
		// Set the  profile data returned by ServiceProviderProfileService service
		ServiceProviderProfile profile = serviceProviderProfileService.getProfile(userID);
		mv.addObject("profile", profile);
		
		// set the current service provider id
		mv.addObject("userID", userID);
		
		return mv;
	}

}