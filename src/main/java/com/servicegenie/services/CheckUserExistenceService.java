//Author
//Kandarp Sharad Parikh
//B00873863

package com.servicegenie.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Service;

import com.servicegenie.daos.BlockedUsersDao;
import com.servicegenie.daos.CheckUserExistenceDao;
import com.servicegenie.daos.ObtainDatabaseConnectionDao;

@Service
//Class to check if the User Already exists at the time of registration
public class CheckUserExistenceService {
	private CheckUserExistenceDao users;

	public CheckUserExistenceService() throws SQLException 
	{
		CheckUserExistenceDao users = new CheckUserExistenceDao();
		this.users = users;
	}
	
	public boolean checkDatabase(String userId , String userType) throws SQLException {
		
		// get user authentication details from database
		ResultSet resultSet = this.users.checkDatabase() ; 

		//Check if the user already exists of the specific type
		// If the UserID of specific type already exists , the User will be redirected to Registration page with error message
		// Else the function will return false and the parent function will continue execution as per the functionality
		while(resultSet.next())
		{
			if(resultSet.getString("User_ID").equals(userId) && resultSet.getString("User_Type").equals(userType))
			{
				return true;
			}
		}
		return false;
	}
}
