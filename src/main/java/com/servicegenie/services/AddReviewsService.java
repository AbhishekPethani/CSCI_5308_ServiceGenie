package com.servicegenie.services;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.servicegenie.ObtainDatabaseConnection;

@Service
public class AddReviewsService {

public static String addReviews(String serviceId,String customerEmail ,String reviewDescription, String reviewStar) {
		ObtainDatabaseConnection dbconnect = new ObtainDatabaseConnection();
		String insertNewServiceQuery = " insert into reviews_details ( review_id, "
				+ "ServiceId, Customer_Email , ReviewDescription, ReviewStar)"
				+ " values (?, ?, ?, ?,?)";

		PreparedStatement MyPreparedStatement;
		try {
			MyPreparedStatement = dbconnect.GetMyConnection().prepareStatement(insertNewServiceQuery);
			MyPreparedStatement.setString (1, null);
			MyPreparedStatement.setString (2, serviceId);
			MyPreparedStatement.setString (3, customerEmail);
			MyPreparedStatement.setString (4, reviewDescription);
			MyPreparedStatement.setString (5, reviewStar);
			
			MyPreparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:AddReviews.html";
	}
}

