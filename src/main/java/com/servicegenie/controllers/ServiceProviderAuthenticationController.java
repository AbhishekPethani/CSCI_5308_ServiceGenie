package com.servicegenie.controllers;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.servicegenie.services.ServiceProviderAuthenticationService;

//author
//Abhishek Pareshbhai Pethani
//B00899521

@Controller
public class ServiceProviderAuthenticationController {
	
	// Object of ServiceProviderAuthenticationService service class
	@Autowired
	private ServiceProviderAuthenticationService serviceProviderAuthenticationService;
	
	// method for handling login request of service provider
	@RequestMapping(method = RequestMethod.POST , value = "/service-provider-authentication")
	public ModelAndView validateUser(@RequestParam("service-provider-userid")String userID, @RequestParam("password") String password) throws SQLException{
		// create object of ModelAndView
		ModelAndView mv = new ModelAndView();
		// set the current service provider id
		mv.addObject("userID", userID);
		// call the service validateUser and check if the user is valid or not
		// this service will return boolean value
		// true if user is valid, false otherwise
		boolean isValidUser = serviceProviderAuthenticationService.validate(userID, password);
		if (isValidUser) {
			int countOfService = serviceProviderAuthenticationService.countService(userID);
			double totalEarning = serviceProviderAuthenticationService.totalEarning(userID);
			mv.addObject("countOfService", countOfService);
			mv.addObject("totalEarning", totalEarning);
			mv.setViewName("ServiceProviderHomePage.html");
		}else {
			mv.setViewName("LoginFailed.html");
		}
		return mv;
	}
	
	// method for handling navigation bar's home menu
	@GetMapping(value = "/my-home-page/{service-provider-userid}")
	public ModelAndView getMyHomePage(@PathVariable("service-provider-userid")String userID) throws SQLException {
		// create object of ModelAndView
		ModelAndView mv = new ModelAndView();
		// set the current service provider id
		mv.addObject("userID", userID);
		// set the view name
		mv.setViewName("ServiceProviderHomePage.html");
		
		int countOfService = serviceProviderAuthenticationService.countService(userID);
		double totalEarning = serviceProviderAuthenticationService.totalEarning(userID);
		mv.addObject("countOfService", countOfService);
		mv.addObject("totalEarning", totalEarning);
		
		return mv;
	}
}
