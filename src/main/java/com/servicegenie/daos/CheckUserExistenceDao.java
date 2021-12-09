package com.servicegenie.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckUserExistenceDao {
	// Obtain Database connection
	Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
	Statement sql ;
	
	public CheckUserExistenceDao() throws SQLException
	{
		this.sql = this.myDBConnect.createStatement();	
	}
	
	// method to return te result set of user authentication details
	public ResultSet checkDatabase() throws SQLException
	{
		ResultSet resultSet = sql.executeQuery("Select User_ID,User_Type from user_authentication;");
		return resultSet;
	}
}
