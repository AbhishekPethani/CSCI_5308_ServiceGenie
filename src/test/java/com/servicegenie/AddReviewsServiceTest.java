package com.servicegenie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.servicegenie.services.AddGrievanceService;
import com.servicegenie.services.AddReviewsService;

class AddReviewsServiceTest {

	AddReviewsService reviews;
	
	public AddReviewsServiceTest()
	{
		reviews = new AddReviewsService();
	}
	
	@Test
	void NotNulltest() {
		assertNotNull(this.reviews);
	}
	

	@Test
	public void getReviewsTest() throws SQLException
	{
		assertThat(this.reviews.addReviews("","","","") instanceof String);
	}
	

}

