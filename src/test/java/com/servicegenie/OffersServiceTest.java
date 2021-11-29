package com.servicegenie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.servicegenie.services.OffersService;
import com.servicegenie.services.ViewOrdersService;

public class OffersServiceTest {
	OffersService offers = new OffersService();
	public OffersServiceTest() throws SQLException {
		OffersService offers = new OffersService();
		this.offers = offers;
	}
	
	//Test to check that the class is not null
	@Test
	void offersserviceNotNull() {
		assertNotNull(this.offers);
	}
	
	//Test to check that all the offers are returned as a list
	@Test
	void getAllOffersTest() throws SQLException {
		assertThat(this.offers.getAllOffers() instanceof List);
	}
	
}
