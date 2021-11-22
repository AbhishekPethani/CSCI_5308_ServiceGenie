package com.servicegenie.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.servicegenie.services.ObtainDatabaseConnectionService;

public class ViewOrdersDao {
	// Obtain Database connection and get customer details for authentication
	ObtainDatabaseConnectionService MyDBConnect = new ObtainDatabaseConnectionService();
	Statement sql ;
	
	public ViewOrdersDao() throws SQLException {
		// TODO Auto-generated constructor stub
		this.sql = this.MyDBConnect.GetMyConnection().createStatement();	
	}
	
	public ResultSet getCustomersId() throws SQLException {
		String query = "SELECT Customer_Email from customer_details;";
		ResultSet rs = this.sql.executeQuery(query);
		return rs;
	}
	
	public ResultSet getServiceProviderId() throws SQLException {
		String query = "SELECT ServiceProviderID from service_provider_details ;";
		ResultSet rs = this.sql.executeQuery(query);
		return rs;
	}
	
	public ResultSet getAllOrders() throws SQLException {
		String query = "SELECT * from orders ;";
		ResultSet rs = this.sql.executeQuery(query);
		return rs;
	}
	
	public ResultSet getOrdersByServiceProvider(String serviceProvider) throws SQLException {
		String query = "SELECT * from orders where service_provider_id = '"+serviceProvider+"' ;";
		ResultSet rs = this.sql.executeQuery(query);
		return rs;
	}
	
	public ResultSet getOrdersByCustomer(String customer_id) throws SQLException {
		String query = "SELECT * from orders where customer_id = '"+customer_id+"' ;";
		ResultSet rs = this.sql.executeQuery(query);
		return rs;
	}
	
}
