package com.servicegenie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.servicegenie.services.ViewReviewsService;

class ViewReviewsServiceTest {

	ViewReviewsService reviews;
	
	public ViewReviewsServiceTest() throws SQLException
	{
		this.reviews = new ViewReviewsService();
	}

	@Test
	public void NotNullTest() {
		assertNotNull(this.reviews);
	}
	
	@Test
	public void getGreivancesTest() throws SQLException
	{
		assertThat(this.reviews.getReviews() instanceof List);
	}

}
