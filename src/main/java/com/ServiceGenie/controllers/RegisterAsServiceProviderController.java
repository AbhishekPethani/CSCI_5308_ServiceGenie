package com.servicegenie.controllers;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.servicegenie.services.RegisterAsServiceProviderService;

//Class to register a new user as a service-provider
@Controller
public class RegisterAsServiceProviderController {
	
	@Autowired
	private RegisterAsServiceProviderService registerasserviceprovider;
	
	@RequestMapping(value = "/RegisterAsServiceProvider", method = RequestMethod.POST)
	public String registerAsAServiceProvider(@RequestParam("service-provider-userid") String userID, @RequestParam("service-provider-fname")String firstName, @RequestParam("service-provider-lname")String lastName,
											 @RequestParam("service-provider-email")String email, @RequestParam("service-provider-contact-number")String contactNumber,
											 @RequestParam("service-provider-street")String street, @RequestParam("service-provider-apt-number")String apartmentNumber,
											 @RequestParam("service-provider-city")String city, @RequestParam("service-provider-zipcode")String zipcode,
											 @RequestParam("service-provider-province")String province, @RequestParam("service-provider-country")String country,
											 @RequestParam("service-provider-category")String category, @RequestParam("service-provider-service-description")String serviceDescription,
											 @RequestParam("service-provider-service-branch-id")String branchID, @RequestParam("service-provider-password")String password) throws SQLException {
		
		return registerasserviceprovider.registerAsAServiceProvider(userID, firstName, lastName, email, contactNumber, street, apartmentNumber, city, zipcode, province, country, category, serviceDescription, branchID, password);
	}

}
