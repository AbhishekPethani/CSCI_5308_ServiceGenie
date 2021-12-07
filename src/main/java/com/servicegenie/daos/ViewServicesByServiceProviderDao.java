//Author
//Kandarp Sharad Parikh
//B00873863

package com.servicegenie.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewServicesByServiceProviderDao {

	// Obtain Database connection and get customer details for authentication
	Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
	Statement sql ;
	
	public ViewServicesByServiceProviderDao() throws SQLException {
		// TODO Auto-generated constructor stub
		this.sql = this.myDBConnect.createStatement();	
	}
	
	public ResultSet getServicesByServiceProvider(String serviceProvider) throws SQLException {
		String query = "SELECT * from services_details where ServiceProviderID = '"+serviceProvider+"' ;";
		ResultSet rs = this.sql.executeQuery(query);
		return rs;
	}
	
	public ResultSet getListOfServiceProviders() throws SQLException {
		ResultSet rs = this.sql.executeQuery("SELECT ServiceProviderID from services_details ;");
		return rs;
	}
		
}
