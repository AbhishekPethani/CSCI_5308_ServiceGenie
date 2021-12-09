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

import com.servicegenie.services.OffersService;
import com.servicegenie.services.*;

@Controller
public class OffersController {
	@Autowired
	private OffersService viewOffers;
	
	@Autowired
	private DeleteOfferService offers;
	
	@RequestMapping(method = RequestMethod.GET , value = "/ViewOffers")
	public String getContentForDropDownList(ModelMap model) throws SQLException
	{   
		model.addAttribute("alloffers", viewOffers.getAllOffers());
		return "ViewOffers.html";
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/DeleteOffers")
	public String deleteOffer(@RequestParam("OfferId")String offerCode, ModelMap model) throws SQLException
	{   
		offers.deleteOffer(offerCode.substring(1));
		model.addAttribute("offercodes", viewOffers.getOfferCodes());
		model.addAttribute("alloffers", viewOffers.getAllOffers());
		return "DeleteOffers.html";
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/DeleteOffers")
	public String getDeleteOfferPage(ModelMap model) throws SQLException
	{   
		model.addAttribute("offercodes", viewOffers.getOfferCodes());
		model.addAttribute("alloffers", viewOffers.getAllOffers());
		return "DeleteOffers.html";
	}
}
