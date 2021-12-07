// Author
// Kandarp Parikh
// B00873863

package com.servicegenie.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.servicegenie.daos.BlockedUsersDao;

@Service
public class BlockedUserService 
{
	private BlockedUsersDao users;

	public BlockedUserService() throws SQLException 
	{
		BlockedUsersDao users = new BlockedUsersDao();
		this.users = users;
	}
	
	// method to retrieve all the details of the blocked users
	public List<ArrayList<String>> getBlockedUserDetails() throws SQLException
	{
		ResultSet resultSet = this.users.getAllBlockedUsers() ;
		List<ArrayList<String>> listOfUsers = new ArrayList<ArrayList<String>>();
		
		while(resultSet.next())
		{
			ArrayList<String> userList = new ArrayList<String>();
			userList.add(resultSet.getString("User_ID"));
			userList.add(resultSet.getString("User_Type"));
			userList.add(resultSet.getString("User_Status"));
			listOfUsers.add(userList);
		}
		
		return listOfUsers;
	}
	
	// method to retrieve all the details of the blocked customers
	public List<ArrayList<String>> getBlockedCustomersDetails() throws SQLException 
	{
		ResultSet resultSet = this.users.getAllBlockedCustomers() ;
		List<ArrayList<String>> listOfUsers = new ArrayList<ArrayList<String>>();
		
		while(resultSet.next())
		{
			ArrayList<String> userList = new ArrayList<String>();
			userList.add(resultSet.getString("User_ID"));
			userList.add(resultSet.getString("User_Type"));
			userList.add(resultSet.getString("User_Status"));
			listOfUsers.add(userList);
		}
		
		return listOfUsers;
	}
	
	// method to retrieve all the details of the blocked Service Providers
	public List<ArrayList<String>> getBlockedServiceProvidersDetails() throws SQLException
	{
		ResultSet resultSet = this.users.getAllBlockedServiceProviders() ;
		List<ArrayList<String>> listOfUsers = new ArrayList<ArrayList<String>>();
		
		while(resultSet.next())
		{
			ArrayList<String> userList = new ArrayList<String>();
			userList.add(resultSet.getString("User_ID"));
			userList.add(resultSet.getString("User_Type"));
			userList.add(resultSet.getString("User_Status"));
			listOfUsers.add(userList);
		}
		
		return listOfUsers;
	}
	
	// method to retrieve User IDs of the blocked customers
	public List<String>  getAllBlockedCustomersID() throws SQLException
	{
		ResultSet blockedCustomers = users.getAllBlockedCustomersID();
		List<String> allBlockedCustomers = new ArrayList<String>();
		
		while(blockedCustomers.next()) 
		{
			allBlockedCustomers.add(blockedCustomers.getString("User_ID"));
		}
		
		return allBlockedCustomers;
	}
	
	// method to retrieve User IDs of the blocked Service Providers
	public List<String> getAllBlockedServiceProvidersID() throws SQLException 
	{
		// list of list to store all the orders of current service provider
		ResultSet blockedServiceProviders = users.getAllBlockedServiceProvidersID();
		List<String> allBlockedServiceProviders = new ArrayList<String>();
		
		while(blockedServiceProviders.next()) 
		{
			allBlockedServiceProviders.add(blockedServiceProviders.getString("User_ID"));
		}
		
		return allBlockedServiceProviders;
	}
	
	// method to retrieve User IDs of the all Service Providers
	public List<String> getAllServiceProvidersID() throws SQLException
	{
		// list of list to store all the orders of current service provider
		ResultSet serviceProviders = users.getAllServiceProvidersID();
		List<String> allServiceProviders = new ArrayList<String>();
		
		while(serviceProviders.next())
		{
			allServiceProviders.add(serviceProviders.getString("User_ID"));
		}
		
		return allServiceProviders;
	}
	
	// method to retrieve User IDs of the all customers
	public List<String>  getAllCustomersID() throws SQLException
	{
		// list of list to store all the orders of current service provider
		ResultSet customers = users.getAllCustomersID();
		List<String> allCustomers = new ArrayList<String>();
		
		while(customers.next())
		{
			allCustomers.add(customers.getString("User_ID"));
		}
		
		return allCustomers;
	}
	
	// method to block the selected user from the dropdown menu
	public void blockUser(String User_ID) throws SQLException
	{
		this.users.blockUser(User_ID);
	}
	
	// method to unblock the selected user from the dropdown menu
	public void unblockUser(String User_ID) throws SQLException
	{
		this.users.unblockUser(User_ID);
	}
}
