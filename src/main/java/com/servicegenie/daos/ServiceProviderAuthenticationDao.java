package com.servicegenie.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//author
//Abhishek Pareshbhai Pethani
//B00899521

public class ServiceProviderAuthenticationDao {
	// method to check if user is valid or not
	public boolean validateUser(String userID , String password) throws SQLException{
	// Obtain Database connection and get service provider details for authentication
	Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
	Statement sql = myDBConnect.createStatement();
			
	// boolean variable to store if user is valid or not
	boolean isValidUser = false;
			
	ResultSet result;
	try {
		result = sql.executeQuery("Select * from user_authentication where User_Type='service-provider';");
			
		// Check if userID and password entered matches or not
		// If the userID and password matches then assign isValidUser with true value
		// otherwise assign false
		while(result.next()){
			if(result.getString("User_ID").equals(userID) && result.getString("User_Password").equals(password)){
				isValidUser = true;
				break;
			}
		}
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return isValidUser;
	}
	
	// method to count number of services provided by service provider
	public int countServicesByServiceProviderID(String userID) throws SQLException {
		int countService = 0;
		// Obtain Database connection and get service provider details for authentication
		Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
		// count all the services which are processed
		Statement sql = myDBConnect.createStatement();
		String query = "select count(*) from orders where service_provider_id = '"+ userID + "' and processed_status='1'";
		ResultSet result = sql.executeQuery(query);
		// get count from result set
		result.next();
		countService = result.getInt(1);
		return countService;
	}
	
	// method to calculate earning
	public double calculateEarning(String userID) throws SQLException {
		double earning = 0;
		// Obtain Database connection and get service provider details for authentication
		Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
		// count all the services which are processed
		Statement sql = myDBConnect.createStatement();
		String query = "select sum(order_amount) from orders where service_provider_id = '"+ userID + "' and processed_status='1'";
		ResultSet result = sql.executeQuery(query);
		// get sum of earning from result set
		result.next();
		earning = result.getDouble(1);
		return earning;
	}
}
