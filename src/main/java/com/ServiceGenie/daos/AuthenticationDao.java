package com.servicegenie.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.servicegenie.services.ObtainDatabaseConnectionService;

//Author
//Kandarp Sharad Parikh
//B00873863

public class AuthenticationDao {
	// Obtain Database connection and get customer details for authentication
	ObtainDatabaseConnectionService MyDBConnect = new ObtainDatabaseConnectionService();
	Statement sql ;
	public AuthenticationDao() throws SQLException{
		this.sql = this.MyDBConnect.getMyConnection().createStatement();	
	}

	//Get credentials of customer 
	public ResultSet getCustomerCredentials() throws SQLException{
		ResultSet rs = sql.executeQuery("Select * from user_authentication where User_Type='customer';");
		MyDBConnect.terminateConnection(MyDBConnect);
		return rs;
	}
}
