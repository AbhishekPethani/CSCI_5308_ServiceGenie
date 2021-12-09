//Author
//Kandarp Sharad Parikh
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

import com.servicegenie.services.ViewServicesByServiceProviderService;

@Controller
public class ViewServicesByServiceProviderController {
	
	@Autowired
	private ViewServicesByServiceProviderService viewservices;
		
	@RequestMapping(method = RequestMethod.GET , value = "/ServiceProviderHomePage")
	public String getContentForDropDownList(ModelMap model) throws SQLException
	{   
		model.addAttribute("serviceProviders", viewservices.getListOfServiceProviders());
		return "ViewServicesByServiceProvider.html";
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/ServiceProviderHomePage")
	public ModelAndView getservices(@RequestParam("service_providerId")String serviceProvider ,ModelMap model , ModelAndView mv) throws SQLException
	{   
		mv.setViewName("ViewServicesByServiceProvider.html");
		mv.addObject("serviceProviders", viewservices.getListOfServiceProviders());
		mv.addObject("services", viewservices.getServiceDetails(serviceProvider.substring(1),model));
		return mv;
	}
	
}
