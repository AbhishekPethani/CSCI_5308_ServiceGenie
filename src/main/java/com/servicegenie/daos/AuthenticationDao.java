//Author
//Kandarp Sharad Parikh
//B00873863

package com.servicegenie.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthenticationDao {
	// Obtain Database connection
	Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
	Statement sql ;
	public AuthenticationDao() throws SQLException
	{
		this.sql = this.myDBConnect.createStatement();	
	}

	//Get credentials of customer 
	public ResultSet getCustomerCredentials() throws SQLException
	{
		ResultSet resultSet = sql.executeQuery("Select * from user_authentication where User_Type='customer';");
		return resultSet;
	}
}
