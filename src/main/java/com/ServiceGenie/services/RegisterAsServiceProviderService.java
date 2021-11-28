package com.servicegenie.services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

//Class to register a new user as a service-provider
@Service
public class RegisterAsServiceProviderService {
	
	
	public String registerAsAServiceProvider(String userID, String firstName, String lastName, String email, String contactNumber, String street, String apartmentNumber, String city, String zipcode, String province, String country, String category, String serviceDescription, String branchID, String password) throws SQLException
	{
		// Creating instance of CheckUserExistence class to verify if the user of type service-provider is already present or not
		// If the UserId is present in database, the user is redirected to Registration page with Error message
		// Else the a new user is registered with service-provider type
		
		CheckUserExistenceService validation = new CheckUserExistenceService();
		
		if(validation.checkDatabase(userID,"service-provider") == true)
		{
			return "RegistrationFailed.html";
		}
		
		ObtainDatabaseConnectionService dbconnect = new ObtainDatabaseConnectionService();
		
		String insertServiceProviderQuery = " insert into service_provider_details (ServiceProviderID, ServiceProvider_FirstName,"
				+ "ServiceProvider_LastName, ServiceProvider_Category, ServiceProvider_CategoryIndex,"
				+ "ServiceProvider_Email, ServiceProvider_ContactNumber,"
				+ "ServiceProvider_Apartment, ServiceProvider_Street, ServiceProvider_City,"
				+ "ServiceProvider_Zipcode, ServiceProvider_Province, ServiceProvider_Country,"
				+ "ServiceProvider_ServiceDescription, ServiceProvider_BranchID)"
			    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		String insertAuthenticationDetailQuery = "insert into user_authentication (User_ID, User_Password, User_Type) values (?, ?, ?)"; 
		
		PreparedStatement MyPreparedStatement = dbconnect.getMyConnection().prepareStatement(insertServiceProviderQuery);
	    MyPreparedStatement.setString (1, userID);
	    MyPreparedStatement.setString (2, firstName);
	    MyPreparedStatement.setString (3, lastName);
	    MyPreparedStatement.setString (4, category);
	    MyPreparedStatement.setString (5, "12");
	    MyPreparedStatement.setString (6, email);
	    MyPreparedStatement.setString (7, contactNumber);
	    MyPreparedStatement.setString (8, apartmentNumber);
	    MyPreparedStatement.setString (9, street);
	    MyPreparedStatement.setString (10, city);
	    MyPreparedStatement.setString (11, zipcode);
	    MyPreparedStatement.setString (12, province);
	    MyPreparedStatement.setString (13, country);
	    MyPreparedStatement.setString (14, serviceDescription);
	    MyPreparedStatement.setString (15, branchID);
	    MyPreparedStatement.execute();

	    MyPreparedStatement = dbconnect.getMyConnection().prepareStatement(insertAuthenticationDetailQuery);
	    MyPreparedStatement.setString (1, userID);
	    MyPreparedStatement.setString (2, password);
	    MyPreparedStatement.setString (3, "service-provider");
	    MyPreparedStatement.execute();
	    
		return "SuccessfulRegistration.html";
		
	}

}
