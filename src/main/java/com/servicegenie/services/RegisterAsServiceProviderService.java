package com.servicegenie.services;

import java.sql.SQLException;
import org.springframework.stereotype.Service;
import com.servicegenie.daos.ServiceProviderProfileDao;
import com.servicegenie.model.ServiceProviderProfile;

//author
//Abhishek Pareshbhai Pethani
//B00899521

//Class to register a new user as a service-provider
@Service
public class RegisterAsServiceProviderService {
	// ServiceProviderProfileDao object
	private ServiceProviderProfileDao serviceProviderProfileDao; 
	
	public RegisterAsServiceProviderService() {
		this.serviceProviderProfileDao = new ServiceProviderProfileDao();
	}
	
	public void setServiceProviderProfileDao(ServiceProviderProfileDao serviceProviderProfileDao) {
		this.serviceProviderProfileDao = serviceProviderProfileDao;
	}

	public boolean registerAsAServiceProvider(String userID, String password, ServiceProviderProfile profile) throws SQLException{
		boolean isSuccessfull = serviceProviderProfileDao.addServiceProviderProfile(userID, profile);
		serviceProviderProfileDao.addServiceProviderAuthenticationDetail(userID, password);
		return isSuccessfull;	
	}
	
	public boolean checkServiceProviderExistenece(String userID) throws SQLException {
		// check if service provider is already exist or not
		boolean isServiceProviderExist = serviceProviderProfileDao.checkIfServiceProviderAlreadyRegistered(userID, "service-provider");
		return isServiceProviderExist;		
	}
}
