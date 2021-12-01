package com.servicegenie.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.servicegenie.services.ObtainDatabaseConnectionService;

public class OffersDao {
	// Obtain Database connection and get customer details for authentication
	ObtainDatabaseConnectionService MyDBConnect = new ObtainDatabaseConnectionService();
	Statement sql ;
	
	public OffersDao() throws SQLException {
		// TODO Auto-generated constructor stub
		this.sql = this.MyDBConnect.getMyConnection().createStatement();	
	}
	
	//Get all offers
	public ResultSet getOffers() throws SQLException {
		String query = "SELECT * from offers;";
		ResultSet rs = this.sql.executeQuery(query);
		MyDBConnect.terminateConnection(MyDBConnect);
		return rs;
	}
	
	//Get all offer codes
	public ResultSet getAllOfferCodes() throws SQLException {
		String query = "SELECT offer_code from offers;";
		ResultSet rs = this.sql.executeQuery(query);
		MyDBConnect.terminateConnection(MyDBConnect);
		return rs;
	}
	
	//Create new Offer
	public void createOffers(String offerCode,String minimumAmount,String discountPercentage) throws SQLException {
		ObtainDatabaseConnectionService dbconnect = new ObtainDatabaseConnectionService();
	      String query = " insert into offers (offer_code, minimum_amount, discount_percentage)"
	    	        + " values (?, ?, ?)";
	      
	      PreparedStatement MyPreparedStatement = dbconnect.getMyConnection().prepareStatement(query);
	      MyPreparedStatement.setString (1, offerCode);
	      MyPreparedStatement.setString (2, minimumAmount);
	      MyPreparedStatement.setString (3, discountPercentage);
	      MyPreparedStatement.execute();
	}
	
}
