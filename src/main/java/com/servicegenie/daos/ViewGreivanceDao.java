package com.servicegenie.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.servicegenie.services.ObtainDatabaseConnectionService;

public class ViewGreivanceDao {
	
	// Obtain Database connection and get customer details for authentication
		ObtainDatabaseConnectionService MyDBConnect = new ObtainDatabaseConnectionService();
		Statement sql ;
		
		public ViewGreivanceDao() throws SQLException {
			// TODO Auto-generated constructor stub
			this.sql = this.MyDBConnect.GetMyConnection().createStatement();	
		}
		
		public ResultSet getCustomerGreivance(String CustomerEmail) throws SQLException {
			String query = "SELECT * FROM grievance_details WHERE Customer_Email = 'xyz' ;";
			query = query.replace("xyz", CustomerEmail);
			ResultSet rs = this.sql.executeQuery(query);
			return rs;
		}

		
		public ResultSet getAllGreivance() throws SQLException {
			String query = "SELECT * from grievance_details;";
			ResultSet rs = this.sql.executeQuery(query);
			return rs;
		}

}
