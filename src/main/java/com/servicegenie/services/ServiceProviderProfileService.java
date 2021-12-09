package com.servicegenie.services;

import java.sql.SQLException;
import org.springframework.stereotype.Service;
import com.servicegenie.daos.ServiceProviderProfileDao;
import com.servicegenie.model.ServiceProviderProfile;

//author
//Abhishek Pareshbhai Pethani
//B00899521

@Service
public class ServiceProviderProfileService {
	// object of ServiceProviderProfileDao
	private ServiceProviderProfileDao serviceProviderProfileDao;
	
	public ServiceProviderProfileService() {
		this.serviceProviderProfileDao = new ServiceProviderProfileDao();
	}
	
	public void setServiceProviderProfileService(ServiceProviderProfileDao serviceProviderProfileDao) {
		this.serviceProviderProfileDao = serviceProviderProfileDao;
	}
	
	public ServiceProviderProfile getProfile(String userID) throws SQLException {
		// Map variable to store profile data
		ServiceProviderProfile profile = serviceProviderProfileDao.getProfileByUserID(userID);
		return profile;		
	}
}
