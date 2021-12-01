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
	
	@RequestMapping(method = RequestMethod.GET , value = "/CreateOffers")
	public String createOffer()
	{
		return "CreateOffer";
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/CreateNewOffer")
	public String createNewOffer(@RequestParam("offercode")String offerCode
			, @RequestParam("minimumamount") String minimumAmount
			,@RequestParam("discountpercentage") String discountPercentage
			,ModelMap model) throws SQLException
	{   
		
		if(offers.checkOfferExistence(offerCode) == true)
		{
			model.addAttribute("alloffers", viewOffers.getAllOffers());
			return "CreateOfferErrorPage";
		}
		else
		{
			model.addAttribute("alloffers", viewOffers.getAllOffers());
			offers.createNewOffer(offerCode, minimumAmount, discountPercentage);	
			return "CreateOfferSuccessPage";
		}
	} 
}
