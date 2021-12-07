//Author
//Kandarp Parikh
//B00873863

package com.servicegenie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.servicegenie.services.CreateOffersService;

public class CreateOffersServiceTest 
{
	CreateOffersService offer = new CreateOffersService();
	public CreateOffersServiceTest() throws SQLException 
	{
		CreateOffersService offer = new CreateOffersService();
		this.offer = offer;
	}
	
	//Test to check that the class is not null 
	@Test
	void createOffersServiceTest() 
	{
		assertNotNull(this.offer);
	}
	
	//Test to check the offer code existence
	@Test
	void createNewOfferTest() throws SQLException 
	{
		String offerCode = "abc";
		assertEquals(this.offer.checkOfferExistence(offerCode), false);
	}
	
}
