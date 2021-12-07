package com.servicegenie.services;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.servicegenie.ObtainDatabaseConnection;

@Service
public class AddServiceService {
	
	public String addService(String serviceName, String serviceDescription, String servicePrice) {
		ObtainDatabaseConnection dbconnect = new ObtainDatabaseConnection();
		String insertNewServiceQuery = " insert into services_details ( ServiceProviderID, "
				+ "ServiceName, ServiceDescription, ServicePrice)"
				+ " values (?, ?, ?, ?)";

		PreparedStatement MyPreparedStatement;
		try {
			MyPreparedStatement = dbconnect.GetMyConnection().prepareStatement(insertNewServiceQuery);
			MyPreparedStatement.setString (1, "1");
			MyPreparedStatement.setString (2, serviceName);
			MyPreparedStatement.setString (3, serviceDescription);
			MyPreparedStatement.setString (4, servicePrice);
			MyPreparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:AddService.html";
	}
}
