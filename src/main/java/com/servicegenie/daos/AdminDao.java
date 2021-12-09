//Author
//Kandarp Sharad Parikh
//B00873863

package com.servicegenie.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdminDao {
	
	// Obtain Database connection and get customer details for authentication
//	ObtainDatabaseConnectionService myDBConnect = new ObtainDatabaseConnectionService();
	Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
	Statement sql ;
	public AdminDao() throws SQLException{
		this.sql = this.myDBConnect.createStatement();	
	}
	
	//Get credentials of admin
	public ResultSet getAdminCredentials() throws SQLException{
		ResultSet resultSet = this.sql.executeQuery("Select * from user_authentication where User_Type='admin';");
		return resultSet;
	}
	
	//Get count of users who are customers
	public Integer getNumberOfCustomers() throws SQLException {
		ResultSet resultSet = this.sql.executeQuery("SELECT COUNT(*) from user_authentication where User_Type='customer';");
	    resultSet.next();
	    int count = resultSet.getInt(1); //getInt(1) returns the total count of results
		return count;
	}
	
	//Get count of users who are service providers
	public Integer getNumberOfServiceProviders() throws SQLException {
		ResultSet resultSet = this.sql.executeQuery("SELECT COUNT(*) from user_authentication where User_Type='service-provider';");
		resultSet.next();
	    int count = resultSet.getInt(1); //getInt(1) returns the total count of results
		return count;
	}

	//Get total number of services
	public Integer getNumberOfServices() throws SQLException {
		ResultSet resultSet = this.sql.executeQuery("SELECT COUNT(*) from services_details");
		resultSet.next();
	    int count = resultSet.getInt(1); //getInt(1) returns the total count of results
		return count;
		
	}
	
	//Get the names of services
	public List<String> getNameOfServices() throws SQLException {
		ResultSet resultSet = this.sql.executeQuery("SELECT ServiceName from services_details");
		List<String> servicesName = new ArrayList<String>();
		while(resultSet.next()) {
		    servicesName.add(resultSet.getString("ServiceName"));
		}
		//Get the unique names of services
		List<String> uniqueServiceNames = servicesName.stream().distinct().collect(Collectors.toList());
		return uniqueServiceNames;
	}
	
}
