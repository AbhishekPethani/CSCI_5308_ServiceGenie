//Author
//Kandarp Sharad Parikh
//B00873863

package com.servicegenie.daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterAsCustomerDao {

	// Obtain Database connection and get customer details for authentication
	Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
	Statement sql ;
	
	public RegisterAsCustomerDao() throws SQLException {
		this.sql = this.myDBConnect.createStatement();	
	}
	
	// Method to register a new user
	public void registerNewCustomer(String userID, String password) throws SQLException
	{
	      String query = " insert into user_authentication (User_Id, User_Password, User_Type)"
	    	        + " values ('"+userID+"','"+password+"','customer')";
	      this.sql.executeUpdate(query);
	}
}
