package com.servicegenie.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.servicegenie.services.OffersService;
import com.servicegenie.services.*;

@Controller
public class OffersController {
	@Autowired
	private OffersService viewOffers;
	
	@RequestMapping(method = RequestMethod.GET , value = "/ViewOffers")
	public String getContentForDropDownList(ModelMap model) throws SQLException
	{   
		model.addAttribute("alloffers", viewOffers.getAllOffers());
		return "ViewOffers.html";
	}
}
