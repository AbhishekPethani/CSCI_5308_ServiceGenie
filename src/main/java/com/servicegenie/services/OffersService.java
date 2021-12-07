//Author
//Kandarp Sharad Parikh
//B00873863

package com.servicegenie.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.servicegenie.daos.OffersDao;

@Service
public class OffersService
{
	private OffersDao offers;

	public OffersService() throws SQLException 
	{
		OffersDao offers = new OffersDao();
		this.offers = offers;
	}
	
	
	//Function to get all the offers
	public List<ArrayList<String>> getAllOffers() throws SQLException
	{
		ResultSet rs = this.offers.getOffers();
		List<ArrayList<String>> alloffers = new ArrayList<ArrayList<String>>();
		
		while(rs.next())
		{
			ArrayList<String> offers = new ArrayList<String>();
			offers.add(rs.getString("offer_id"));
			offers.add(rs.getString("offer_code"));
			offers.add(rs.getString("minimum_amount"));
			offers.add(rs.getString("discount_percentage"));
			alloffers.add(offers);
		}
		
		return alloffers;
	}
	
	//Function to get all the offer codes
	public List<String> getOfferCodes() throws SQLException
	{
		// list of list to store all the orders of current service provider
		ResultSet offerCodes = offers.getAllOfferCodes();
		List<String> alloffers = new ArrayList<String>();
		
		while(offerCodes.next()) 
		{
			alloffers.add(offerCodes.getString("offer_code"));
		}
		
		return alloffers;
	}
}
