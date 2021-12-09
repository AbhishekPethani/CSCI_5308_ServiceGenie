package com.servicegenie.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.servicegenie.model.ServiceProviderProfile;

//author
//Abhishek Pareshbhai Pethani
//B00899521

public class ServiceProviderProfileDao {
	
	public ServiceProviderProfile getProfileByUserID(String userID) throws SQLException {
		// Obtain Database connection and get service provider profile
		Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
		
		// ServiceProviderProfile variable to store profile data
		ServiceProviderProfile profile = new ServiceProviderProfile();
		
		try {
			// execute sql query
			Statement sql = myDBConnect.createStatement();
			ResultSet result = sql.executeQuery("Select * from service_provider_details where ServiceProviderID= '" + userID +"';");	
			// fetch the data from ResultSet object
			result.next();
			
			String firstName = result.getString("ServiceProvider_FirstName");
			profile.setFirstName(firstName);
			
			String lastName = result.getString("ServiceProvider_LastName");
			profile.setLastName(lastName);
			
			String category = result.getString("ServiceProvider_Category");
			profile.setCategory(category);
			
			String description = result.getString("ServiceProvider_ServiceDescription");
			profile.setServiceDescription(description);
			
			String email = result.getString("ServiceProvider_Email");
			profile.setEmail(email);
			
			String contactNumber = result.getString("ServiceProvider_ContactNumber");
			profile.setContactNumber(contactNumber);
			
			String apartment = result.getString("ServiceProvider_Apartment");
			profile.setApartmentNumber(apartment);
			
			String streetName = result.getString("ServiceProvider_Street");
			profile.setStreetName(streetName);
			
			String city = result.getString("ServiceProvider_City");
			profile.setCity(city);
			
			String zipcode = result.getString("ServiceProvider_Zipcode");
			profile.setZipcode(zipcode);
			
			String province = result.getString("ServiceProvider_Province");
			profile.setProvince(province);
			
			String country = result.getString("ServiceProvider_Country");
			profile.setCountry(country);
		}catch(Exception e) {
			System.out.println(e);
		}		
		return profile;	
	}
	
	public boolean addServiceProviderProfile(String userID, ServiceProviderProfile profile) throws SQLException {
		// Obtain Database connection and get service provider profile
		Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
		
		String insertServiceProviderQuery = " insert into service_provider_details (ServiceProviderID, ServiceProvider_FirstName,"
						+ "ServiceProvider_LastName, ServiceProvider_Category,"
						+ "ServiceProvider_Email, ServiceProvider_ContactNumber,"
						+ "ServiceProvider_Apartment, ServiceProvider_Street, ServiceProvider_City,"
						+ "ServiceProvider_Zipcode, ServiceProvider_Province, ServiceProvider_Country,"
						+ "ServiceProvider_ServiceDescription)"
					    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
						
		PreparedStatement preparedStatement = myDBConnect.prepareStatement(insertServiceProviderQuery);
		preparedStatement.setString (1, userID);
		preparedStatement.setString (2, profile.getFirstName());
		preparedStatement.setString (3, profile.getLastName());
		preparedStatement.setString (4, profile.getCategory());
		preparedStatement.setString (5, profile.getEmail());
		preparedStatement.setString (6, profile.getContactNumber());
		preparedStatement.setString (7, profile.getApartmentNumber());
		preparedStatement.setString (8, profile.getStreetName());
		preparedStatement.setString (9, profile.getCity());
		preparedStatement.setString (10, profile.getZipcode());
		preparedStatement.setString (11, profile.getProvince());
		preparedStatement.setString (12, profile.getCountry());
		preparedStatement.setString (13, profile.getServiceDescription());
		preparedStatement.execute();
		
		return true;
	}
	
	public boolean addServiceProviderAuthenticationDetail(String userID, String password) throws SQLException {
		// Obtain Database connection and get service provider profile
		Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
		
		String insertAuthenticationDetailQuery = "insert into user_authentication (User_ID, User_Password, User_Type) values (?, ?, ?)"; 
		PreparedStatement preparedStatement = myDBConnect.prepareStatement(insertAuthenticationDetailQuery);
	    preparedStatement.setString (1, userID);
	    preparedStatement.setString (2, password);
	    preparedStatement.setString (3, "service-provider");
	    preparedStatement.execute();
	    
		return true;
	}
	
	public boolean checkIfServiceProviderAlreadyRegistered(String userID, String userType) throws SQLException {
		boolean isExist = false;
		// Obtain Database connection and get service provider profile
		Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
		Statement sql = myDBConnect.createStatement();
		ResultSet result = sql.executeQuery("Select User_ID,User_Type from user_authentication;"); 
		
		while(result.next()){
			if(result.getString("User_ID").equals(userID) && result.getString("User_Type").equals(userType)){
				isExist = true;
			}
		}
		return isExist;
	}
}
