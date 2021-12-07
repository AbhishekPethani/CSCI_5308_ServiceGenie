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

import com.servicegenie.services.CreateOffersService;
import com.servicegenie.services.OffersService;

@Controller
public class CreateOffersController {
	@Autowired
	private CreateOffersService offers;
	
	@Autowired
	private OffersService viewOffers;
	
	// Redirects to CreateOffers page when a get request is invoked for this mapping
	@RequestMapping(method = RequestMethod.GET , value = "/CreateOffers")
	public String createOffer(ModelMap model) throws SQLException
	{
		model.addAttribute("alloffers", viewOffers.getAllOffers());
		return "CreateOffer";
	}
	
	// Controller for creating a new offer when a get post is invoked for this mapping
	// Redirects to error page CreateOfferErrorPage if the offer already exists
	// Redirects to success page CreateOfferSuccessPage if the new offer has been created
	@RequestMapping(method = RequestMethod.POST , value = "/CreateNewOffer")
	public String createNewOffer(
			 @RequestParam("offercode")String offerCode
			,@RequestParam("minimumamount") String minimumAmount
			,@RequestParam("discountpercentage") String discountPercentage
			,ModelMap model) throws SQLException
	{   
		
		// If the offer code already exists then the admin will be redirected to the Error page
		if(offers.checkOfferExistence(offerCode) == true)
		{
			model.addAttribute("alloffers", viewOffers.getAllOffers());
			return "CreateOfferErrorPage";
		}
		// If the offer code does not already exists then the admin will be redirected to the success page
		else
		{
			offers.createNewOffer(offerCode, minimumAmount, discountPercentage);
			model.addAttribute("alloffers", viewOffers.getAllOffers());
			return "CreateOfferSuccessPage";
		}
	} 
}
