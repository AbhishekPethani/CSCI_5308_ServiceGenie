package com.servicegenie.controllers;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.servicegenie.model.ServiceProviderProfile;
import com.servicegenie.services.RegisterAsServiceProviderService;

//author
//Abhishek Pareshbhai Pethani
//B00899521

//Class to register a new user as a service-provider
@Controller
public class RegisterAsServiceProviderController {
	
	@Autowired
	private RegisterAsServiceProviderService registerAsAServiceProviderService;
	
	@RequestMapping(value = "/RegisterAsServiceProvider", method = RequestMethod.POST)
	public ModelAndView registerAsAServiceProvider(@RequestParam("service-provider-userid") String userID, @RequestParam("service-provider-fname")String firstName, @RequestParam("service-provider-lname")String lastName,
											 @RequestParam("service-provider-email")String email, @RequestParam("service-provider-contact-number")String contactNumber,
											 @RequestParam("service-provider-street")String street, @RequestParam("service-provider-apt-number")String apartmentNumber,
											 @RequestParam("service-provider-city")String city, @RequestParam("service-provider-zipcode")String zipcode,
											 @RequestParam("service-provider-province")String province, @RequestParam("service-provider-country")String country,
											 @RequestParam("service-provider-category")String category, @RequestParam("service-provider-service-description")String serviceDescription,
											 @RequestParam("service-provider-password")String password) throws SQLException {
		
		
		ModelAndView mv = new ModelAndView();
		if(registerAsAServiceProviderService.checkServiceProviderExistenece(userID)) {
			mv.setViewName("RegistrationFailed.html");
			return mv;
		}
		
		ServiceProviderProfile profile = new ServiceProviderProfile();
		profile.setFirstName(firstName);
		profile.setLastName(lastName);
		profile.setCategory(category);
		profile.setServiceDescription(serviceDescription);
		profile.setEmail(email);
		profile.setContactNumber(contactNumber);
		profile.setApartmentNumber(apartmentNumber);
		profile.setStreetName(street);
		profile.setCity(city);
		profile.setZipcode(zipcode);
		profile.setProvince(province);
		profile.setCountry(country);
		
		if(registerAsAServiceProviderService.registerAsAServiceProvider(userID, password, profile)) {
			mv.setViewName("SuccessfulRegistration.html");
		}
		return mv;
	}
}
