package com.servicegenie.daos;

//Author
//Kandarp Sharad Parikh
//B00873863

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerAuthenticationDao 
{
	// Obtain Database connection
	Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
	Statement sql ;
	
	public CustomerAuthenticationDao() throws SQLException
	{
		this.sql = this.myDBConnect.createStatement();	
	}
	
	// Method to get all the user credentials of customers
	public ResultSet validateUser(String userId,String password) throws SQLException
	{
		ResultSet resultSet = sql.executeQuery("Select * from user_authentication where User_Type='customer';");
		return resultSet;
	}
}
