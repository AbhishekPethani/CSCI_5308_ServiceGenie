//Author
//Kandarp Sharad Parikh
//B00873863

package com.servicegenie.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class OffersDao 
{
	// Obtain Database connection and get customer details for authentication
	Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
	Statement sql ;
	
	public OffersDao() throws SQLException
	{
		this.sql = this.myDBConnect.createStatement();	
	}
	
	//Get all offers
	public ResultSet getOffers() throws SQLException
	{
		String query = "SELECT * from offers;";
		ResultSet rs = this.sql.executeQuery(query);
		return rs;
	}
	
	//Get all offer codes
	public ResultSet getAllOfferCodes() throws SQLException 
	{
		String query = "SELECT offer_code from offers;";
		ResultSet resultset = this.sql.executeQuery(query);
		return resultset;
	}
	
	//Method to delete a certain offer from offer code
	public void deleteOffer(String offerCode) throws SQLException
	{
		
		String query = "DELETE from offers where offer_code='"+offerCode+"' ;";
		System.out.println(query);
		this.sql.executeUpdate(query);
	}
	
	//Create new Offer
	public void createOffers(String offerCode,String minimumAmount,String discountPercentage) throws SQLException
	{
	      String query = " insert into offers (offer_code, minimum_amount, discount_percentage)"
	    	        + " values (?, ?, ?)";
	      
	      PreparedStatement MyPreparedStatement = myDBConnect.prepareStatement(query);
	      MyPreparedStatement.setString (1, offerCode);
	      MyPreparedStatement.setString (2, minimumAmount);
	      MyPreparedStatement.setString (3, discountPercentage);
	      MyPreparedStatement.execute();
	}
}
