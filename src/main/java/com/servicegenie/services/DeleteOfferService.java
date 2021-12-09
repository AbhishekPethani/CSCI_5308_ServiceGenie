//Author
//Kandarp Sharad Parikh
//B00873863

package com.servicegenie.services;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.servicegenie.daos.OffersDao;

@Service
public class DeleteOfferService {
	
	// Method to delete the selected offer code
	public void deleteOffer(String offerCode) throws SQLException
	{
		OffersDao offer = new OffersDao();
		offer.deleteOffer(offerCode);
	}
}
