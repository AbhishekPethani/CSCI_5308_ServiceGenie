package com.servicegenie.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.servicegenie.daos.OffersDao;
import com.servicegenie.daos.*;

@Service
public class OffersService {
	private OffersDao offers;

	public OffersService() throws SQLException {
		OffersDao offers = new OffersDao();
		this.offers = offers;
		}
	
	
	//Function to get all the offers
	public List<ArrayList<String>> getAllOffers() throws SQLException
	{
		ResultSet rs = this.offers.getOffers();
		List<ArrayList<String>> alloffers = new ArrayList<ArrayList<String>>();
		while(rs.next()) {
			ArrayList<String> offers = new ArrayList<String>();
			offers.add(rs.getString("offer_id"));
			offers.add(rs.getString("offer_code"));
			offers.add(rs.getString("minimum_amount"));
			offers.add(rs.getString("discount_percentage"));
			alloffers.add(offers);
		}
		return alloffers;
	}
	
}
