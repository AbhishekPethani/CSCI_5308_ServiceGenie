package com.servicegenie.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.servicegenie.services.ObtainDatabaseConnectionService;

public class AdminDao {
	
	// Obtain Database connection and get customer details for authentication
	ObtainDatabaseConnectionService MyDBConnect = new ObtainDatabaseConnectionService();
	Statement sql ;
	public AdminDao() throws SQLException{
		this.sql = this.MyDBConnect.GetMyConnection().createStatement();	
	}
	
	public ResultSet getAdminCredentials() throws SQLException{
		ResultSet rs = this.sql.executeQuery("Select * from user_authentication where User_Type='admin';");
		return rs;
	}
	
	public Integer getNumberOfCustomers() throws SQLException {
		ResultSet rs = this.sql.executeQuery("SELECT COUNT(*) from user_authentication where User_Type='customer';");
	    rs.next();
	    int count = rs.getInt(1);
		return count;
	}
	
	public Integer getNumberOfServiceProviders() throws SQLException {
		ResultSet rs = this.sql.executeQuery("SELECT COUNT(*) from user_authentication where User_Type='service-provider';");
	    rs.next();
	    int count = rs.getInt(1);
		return count;
	}

	public Integer getNumberOfServices() throws SQLException {
		ResultSet rs = this.sql.executeQuery("SELECT COUNT(*) from services_details");
	    rs.next();
	    int count = rs.getInt(1);
		return count;
		
	}
	
	public List<String> getNameOfServices() throws SQLException {
		ResultSet rs = this.sql.executeQuery("SELECT ServiceName from services_details");
		List<String> servicesName = new ArrayList<String>();
		while(rs.next()) {
		    servicesName.add(rs.getString("ServiceName"));
		}
		List<String> uniqueServiceNames = servicesName.stream().distinct().collect(Collectors.toList());
		return uniqueServiceNames;
	}
	
}
