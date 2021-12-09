package com.servicegenie.services;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.servicegenie.ObtainDatabaseConnection;

@Service
public class AddGrievanceService {

public static String addGrievances(String customerEmail ,String serviceId,String greivanceDescription) {
		ObtainDatabaseConnection dbconnect = new ObtainDatabaseConnection();
		String insertNewServiceQuery = " insert into grievance_details ( GrievanceId, "
				+ "Customer_Email, ServiceId , GrievanceDescription)"
				+ " values (?, ?, ?,?)";

		PreparedStatement MyPreparedStatement;
		try {
			MyPreparedStatement = dbconnect.GetMyConnection().prepareStatement(insertNewServiceQuery);
			MyPreparedStatement.setString (1, null);
			MyPreparedStatement.setString (2, customerEmail);
			MyPreparedStatement.setString (3, serviceId);
			MyPreparedStatement.setString (4, greivanceDescription);
			
			
			MyPreparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:AddGrievance.html";
	}
}

