// Author
// Kandarp Parikh
// B00873863

package com.servicegenie.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BlockedUsersDao 
{
	// Obtain Database connection
	Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
	Statement sql ;
	
	public BlockedUsersDao() throws SQLException
	{
		this.sql = this.myDBConnect.createStatement();	
	}
	
	// method to get all the details of the blocked user
	public ResultSet getAllBlockedUsers() throws SQLException
	{
		ResultSet resultSet = sql.executeQuery("Select * from user_authentication where User_Status='Blocked';");
		return resultSet;
	}
	
	// method to get all the details of the blocked customers
	public ResultSet getAllBlockedCustomers() throws SQLException
	{
		ResultSet resultSet = sql.executeQuery("Select * from user_authentication where User_Type='customer' and User_Status='Blocked';");
		return resultSet;
	}
	
	// method to get all the details of the blocked service providers
	public ResultSet getAllBlockedServiceProviders() throws SQLException
	{
		ResultSet resultSet = sql.executeQuery("Select * from user_authentication where User_Type='service-provider' and User_Status='Blocked';");
		return resultSet;
	}
	
	// method to get UserIDs of the blocked customers
	public ResultSet getAllBlockedCustomersID() throws SQLException
	{
		ResultSet resultSet = sql.executeQuery("Select User_ID from user_authentication where User_Type='customer' and User_Status='Blocked';");
		return resultSet;
	}
	
	// method to get UserIDs of the blocked service providers
	public ResultSet getAllBlockedServiceProvidersID() throws SQLException
	{
		ResultSet resultSet = sql.executeQuery("Select User_ID from user_authentication where User_Type='service-provider' AND User_Status='Blocked';");
		return resultSet;
	}
	
	// method to get UserIDs of all the customers
	public ResultSet getAllCustomersID() throws SQLException
	{
		ResultSet resultSet = sql.executeQuery("Select User_ID from user_authentication where User_Type='customer';");
		return resultSet;
	}

	// method to get UserIDs of all the ServiceProviders
	public ResultSet getAllServiceProvidersID() throws SQLException
	{
		ResultSet resultSet = sql.executeQuery("Select User_ID from user_authentication where User_Type='service-provider'; ");
		return resultSet;
	}
	
	// method to update the User Status as blocked for the selected user
	public void blockUser(String User_ID) throws SQLException
	{
		String query = "Update user_authentication set User_Status='Blocked' where User_ID='"+User_ID+"';";
		sql.executeUpdate(query);
	}
	
	// method to update the User Status as unblocked for the selected user
	public void unblockUser(String User_ID) throws SQLException
	{
		String query = "Update user_authentication set User_Status='Unblocked' where User_ID='"+User_ID+"';";
		sql.executeUpdate(query);
	}
}
