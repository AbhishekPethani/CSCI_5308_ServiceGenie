//Authors : 
// Kandarp
// Arjun
// Abhishek

package com.servicegenie.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ObtainDatabaseConnectionDao
{
	Connection connect;
	private static ObtainDatabaseConnectionDao instance;
	private ObtainDatabaseConnectionDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_19_DEVINT?useSSL=false","CSCI5308_19_DEVINT_USER","ule1Guha4eracie1");
		} catch (ClassNotFoundException e) {
			System.out.println("Database connection Error encountered");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ObtainDatabaseConnectionDao getInstance() {
		if(instance == null) {
			instance = new ObtainDatabaseConnectionDao();
		}
		return instance;
	}
	
	public Connection getMyConnection() {
		return connect;
	}
	
	// Function for terminating Database connection
	public boolean TerminateConnection(Connection myConnection) throws SQLException
	{
		if (myConnection.isClosed() == false)
		{
			myConnection.close();
		}
		return true;
	}

//	Connection connect = null;
//	
//	//Fucntion to establish connection , The function returns the connection object which denotes the successful connection with database
//	public Connection getMyConnection() throws SQLException
//	{
//	try
//		{
//			Class.forName("com.mysql.jdbc.Driver");
//			connect = DriverManager.getConnection("jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_19_DEVINT?useSSL=false","CSCI5308_19_DEVINT_USER","ule1Guha4eracie1");
//		} 
//	
//	catch (ClassNotFoundException e)
//		{
//			System.out.println("Database connection Error encountered");
//			e.printStackTrace();
//		}
//	
//	return connect;
//	}
//
//	
//	// Function for terminating Database connection
//	public boolean terminateConnection(ObtainDatabaseConnectionService MyConnection) throws SQLException
//	{
//		if (MyConnection.getMyConnection().isClosed() == false)
//		{
//			MyConnection.connect.close();
//		}
//		return true;
//	}
}

