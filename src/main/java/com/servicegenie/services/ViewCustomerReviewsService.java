
package com.servicegenie.services;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.servicegenie.daos.ViewReviewsDao;
import com.servicegenie.models.Reviews;

@Service
public class ViewCustomerReviewsService {
	
	private ViewReviewsDao viewServiceDao;
	
	public ViewCustomerReviewsService() throws SQLException{
		ViewReviewsDao viewReviewsDao = new ViewReviewsDao();
		this.viewServiceDao = viewReviewsDao;
	}
	
	
	public List<Reviews> getCustomerReviews (String CustomerEmail) throws SQLException {
		List<Reviews> reviews = new ArrayList<Reviews>();
		
		ResultSet resultSet = viewServiceDao.getCustomerReviews(CustomerEmail);
		
		while (resultSet.next()) {
			String reviewID = resultSet.getString("review_id");
			String serviceID = resultSet.getString("ServiceId");
			String customerEmail = resultSet.getString("Customer_Email");
			String reviewDescription = resultSet.getString("ReviewDescription");
			String reviewStar = resultSet.getString("ReviewStar");
			
			Reviews r = new Reviews(reviewID, serviceID, customerEmail, reviewDescription, reviewStar);
			
			reviews.add(r);
		}
		
		return reviews;	
	}
	
}
