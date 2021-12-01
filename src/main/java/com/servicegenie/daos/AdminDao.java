package com.servicegenie.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.servicegenie.services.ObtainDatabaseConnectionService;

//Author
//Kandarp Sharad Parikh
//B00873863
 //AdminDAO
public class AdminDao {
	
	// Obtain Database connection and get customer details for authentication
	ObtainDatabaseConnectionService MyDBConnect = new ObtainDatabaseConnectionService();
	Statement sql ;
	public AdminDao() throws SQLException{
		this.sql = this.MyDBConnect.getMyConnection().createStatement();	
	}
	
	//Get credentials of admin
	public ResultSet getAdminCredentials() throws SQLException{
		ResultSet rs = this.sql.executeQuery("Select * from user_authentication where User_Type='admin';");
		MyDBConnect.terminateConnection(MyDBConnect);
		return rs;
	}
	
	//Get count of users who are customers
	public Integer getNumberOfCustomers() throws SQLException {
		ResultSet rs = this.sql.executeQuery("SELECT COUNT(*) from user_authentication where User_Type='customer';");
	    rs.next();
	    int count = rs.getInt(1);
	    MyDBConnect.terminateConnection(MyDBConnect);
		return count;
	}
	
	//Get count of users who are service providers
	public Integer getNumberOfServiceProviders() throws SQLException {
		ResultSet rs = this.sql.executeQuery("SELECT COUNT(*) from user_authentication where User_Type='service-provider';");
	    rs.next();
	    int count = rs.getInt(1);
	    MyDBConnect.terminateConnection(MyDBConnect);
		return count;
	}

	//Get total number of services
	public Integer getNumberOfServices() throws SQLException {
		ResultSet rs = this.sql.executeQuery("SELECT COUNT(*) from services_details");
	    rs.next();
	    int count = rs.getInt(1);
	    MyDBConnect.terminateConnection(MyDBConnect);
		return count;
		
	}
	
	//Get the names of services
	public List<String> getNameOfServices() throws SQLException {
		ResultSet rs = this.sql.executeQuery("SELECT ServiceName from services_details");
		List<String> servicesName = new ArrayList<String>();
		while(rs.next()) {
		    servicesName.add(rs.getString("ServiceName"));
		}
		//Get the unique names of services
		List<String> uniqueServiceNames = servicesName.stream().distinct().collect(Collectors.toList());
		MyDBConnect.terminateConnection(MyDBConnect);
		return uniqueServiceNames;
	}
	
}
