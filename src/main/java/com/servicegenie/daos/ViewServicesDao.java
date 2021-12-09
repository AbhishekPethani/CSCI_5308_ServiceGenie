package com.servicegenie.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.servicegenie.model.ServiceProviderServices;

//author
//Abhishek Pareshbhai Pethani
//B00899521

public class ViewServicesDao {
			
	public List<ServiceProviderServices> getAllServices(String userID) throws SQLException {
		// Obtain Database connection and get service provider profile
		Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
		
		// list of ServiceProviderServices to store all the services for specific service provider
		List<ServiceProviderServices> services = new ArrayList<ServiceProviderServices>();
		
		try {
			// execute sql query
			Statement sql = myDBConnect.createStatement();
			ResultSet result = sql.executeQuery("Select * from services_details where ServiceProviderID= '" +userID + "';");	
			// fetch the data from ResultSet object
			while(result.next()) {
				String serviceID = result.getString("ServiceID");
                String serviceName = result.getString("ServiceName");
                String serviceDescription = result.getString("ServiceDescription");
                Double servicePrice = result.getDouble("ServicePrice");
                ServiceProviderServices service = new ServiceProviderServices(serviceID, serviceName, serviceDescription ,servicePrice);
                services.add(service);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return services;
	}
}
