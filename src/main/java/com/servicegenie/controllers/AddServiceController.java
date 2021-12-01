package com.servicegenie.controllers;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.servicegenie.services.AddServiceService;

@Controller
public class AddServiceController {
	
	@Autowired
	private AddServiceService addService;
	
	@RequestMapping(method = RequestMethod.POST , value = "/add-service")
	public String AddNewService(@RequestParam("service-name")String serviceName, @RequestParam("service-description")String serviceDescription, @RequestParam("service-price")String servicePrice) throws SQLException {
		
		return addService.addService(serviceName, serviceDescription, servicePrice);
		
	}
}
