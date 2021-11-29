package com.servicegenie.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.servicegenie.daos.AdminDao;
import com.servicegenie.daos.OffersDao;
import com.servicegenie.daos.ViewOrdersDao;

@Service
public class CreateOffersService {
	private OffersDao offers;

	public CreateOffersService() throws SQLException {
		OffersDao offers = new OffersDao();
		this.offers = offers;
		}
	
	public boolean checkOfferExistence(String offerCode) throws SQLException {
			
			ResultSet result = offers.getAllOfferCodes();
			while(result.next())
			{
				if(result.getString("offer_code").equals(offerCode))
				{
					return true;
				}
			}
			return false;
		}
	
	public void createNewOffer(String offerCode , String minimumAmount , String discountPercentage) throws SQLException
	{
		offers.createOffers(offerCode,minimumAmount,discountPercentage);
	}
}
