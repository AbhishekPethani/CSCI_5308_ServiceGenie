package com.servicegenie.controllers;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.servicegenie.model.ServiceProviderServices;
import com.servicegenie.services.ViewServicesService;

//author
//Abhishek Pareshbhai Pethani
//B00899521

@Controller
public class ViewServicesController {
	// Object of ViewServicesService service class
	@Autowired
	public ViewServicesService viewServicesService;
		
	// Controller for handling service provider profile request
	@RequestMapping(method = RequestMethod.GET , value = "/view-all-services/{service-provider-userid}")
	public ModelAndView getAllServices(@PathVariable("service-provider-userid")String userID) throws SQLException {
		// create object of ModelAndView
		ModelAndView mv = new ModelAndView();
		
		// set the name of returning view 
		mv.setViewName("ViewServices.html");
		
		// Set the  profile data returned by ServiceProviderProfileService service
		List<ServiceProviderServices> services = viewServicesService.getServices(userID);
		mv.addObject("services", services);
		
		// set the current service provider id
		mv.addObject("userID", userID);
		
		return mv;
	}
}
