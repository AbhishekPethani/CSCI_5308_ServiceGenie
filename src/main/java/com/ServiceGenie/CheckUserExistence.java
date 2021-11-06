package com.servicegenie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


//Class to check if the User Already exists at the time of registration
public class CheckUserExistence {
	
	public boolean CheckDatabase(String UserId , String UserType) throws SQLException {
		
		//Establish Database connection and check retrieve all the usersIds and their Types
		ObtainDatabaseConnection dbconnect = new ObtainDatabaseConnection();
		Statement sql = dbconnect.GetMyConnection().createStatement();
		ResultSet result = sql.executeQuery("Select User_ID,User_Type from user_authentication;"); 

		//Check if the user already exsts of the specific type
		// If the UserID of specific type already exists , the User will be redirected to Registration page with error message
		// Else the function will return false and the parent function will continue execution as per the functionality
		while(result.next())
		{
			if(result.getString("User_ID").equals(UserId) && result.getString("User_Type").equals(UserType))
			{
				return true;
			}
		}
		return false;
	}
}
