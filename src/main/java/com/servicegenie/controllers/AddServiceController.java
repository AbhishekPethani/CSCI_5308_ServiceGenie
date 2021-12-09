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
import com.servicegenie.model.ServiceProviderServices;
import com.servicegenie.services.AddServiceService;

// author
// Abhishek Pareshbhai Pethani
// B00899521

@Controller
public class AddServiceController {
	
	// Object of AddServicesService class
	@Autowired
	private AddServiceService addService;
	
	// method to handle Add Service link on service provide home page
	// it will return AddService view
	@GetMapping(value = "/get-new-service-view/{service-provider-userid}")
	public ModelAndView getNewServiceView(@PathVariable("service-provider-userid")String userID) {
		// create object of ModelAndView
		ModelAndView mv = new ModelAndView();
		// set the current service provider id
		mv.addObject("userID", userID);
		// set the view name
		mv.setViewName("AddService.html");
		return mv;
	}
	
	// method to handle click event in AddService view
	@RequestMapping(method = RequestMethod.POST , value = "/add-new-service/{service-provider-userid}")
	public ModelAndView AddNewService(@PathVariable("service-provider-userid")String userID, @RequestParam("service-name")String serviceName, @RequestParam("service-description")String serviceDescription, @RequestParam("service-price")Double servicePrice) throws SQLException {
		// create object of ModelAndView
		ModelAndView mv = new ModelAndView();
		// set the current service provider id
		mv.addObject("userID", userID);
		
		ServiceProviderServices service = new ServiceProviderServices();
		service.setServiceProviderID(userID);
		service.setServiceName(serviceName);
		service.setServiceDescription(serviceDescription);
		service.setServicePrice(servicePrice);
		
		// call the addService method  
		String message = addService.addService(service);
		// set the message returned by addService method
		mv.addObject("message", message);
		// set the view name
		mv.setViewName("AddService.html");
		return mv;
	}
}
