//Author
//Kandarp Sharad Parikh
//B00873863

package com.servicegenie.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Service;

import com.servicegenie.daos.ObtainDatabaseConnectionDao;

@Service
//Class to check if the User Already exists at the time of registration
public class CheckUserExistenceService {
	
	public boolean checkDatabase(String userId , String userType) throws SQLException {
		
		//Establish Database connection and check retrieve all the usersIds and their Types
		Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
		Statement sql = myDBConnect.createStatement();
		ResultSet result = sql.executeQuery("Select User_ID,User_Type from user_authentication;"); 

		//Check if the user already exists of the specific type
		// If the UserID of specific type already exists , the User will be redirected to Registration page with error message
		// Else the function will return false and the parent function will continue execution as per the functionality
		while(result.next())
		{
			if(result.getString("User_ID").equals(userId) && result.getString("User_Type").equals(userType))
			{
				return true;
			}
		}
		return false;
	}
}
