package com.servicegenie.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//Author
//Kandarp Sharad Parikh
//B00873863

public class ObtainDatabaseConnectionService
{
	Connection connect = null;
	
	//Function to establish connection , The function returns the connection object which denotes the successful connection with database
	public Connection getMyConnection() throws SQLException
	{
	try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_19_DEVINT?useSSL=false","CSCI5308_19_DEVINT_USER","ule1Guha4eracie1");
		} 
	
	catch (ClassNotFoundException e)
		{
			System.out.println("Database connection Error encountered");
			e.printStackTrace();
		}
	
	return connect;
	}

	
	// Function for terminating Database connection
	public boolean terminateConnection(ObtainDatabaseConnectionService MyConnection) throws SQLException
	{
		if (MyConnection.getMyConnection().isClosed() == false)
		{
			MyConnection.connect.close();
		}
		return true;
	}
}

