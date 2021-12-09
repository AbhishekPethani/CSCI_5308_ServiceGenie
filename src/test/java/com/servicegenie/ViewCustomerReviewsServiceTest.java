package com.servicegenie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.servicegenie.services.ViewCustomerReviewsService;

public class ViewCustomerReviewsServiceTest {

	ViewCustomerReviewsService services;

	public ViewCustomerReviewsServiceTest() throws SQLException {
		ViewCustomerReviewsService services = new ViewCustomerReviewsService();
		this.services = services;
	}

	@Test
	public void NotNullTest() {
		assertNotNull(this.services);
	}
	
	@Test
	public void getReviewsTest() throws SQLException
	{
		assertThat(this.services.getCustomerReviews("") instanceof List);
	}
	
	

}