package com.servicegenie.services;

import java.sql.SQLException;
import org.springframework.stereotype.Service;
import com.servicegenie.daos.ServiceProviderAuthenticationDao;

//author
//Abhishek Pareshbhai Pethani
//B00899521

@Service
public class ServiceProviderAuthenticationService {
	// object of AddServiceDao
	private static ServiceProviderAuthenticationDao serviceProviderAuthenticationDao = new ServiceProviderAuthenticationDao();
	
	public boolean validate(String userID, String password) throws SQLException {
		// String message for displaying operations result on UI
		boolean isValidUser = false;
		isValidUser = serviceProviderAuthenticationDao.validateUser(userID, password);
		return isValidUser;
	}	
	
	public int countService(String userID) throws SQLException {
		int count = 0;
		count = serviceProviderAuthenticationDao.countServicesByServiceProviderID(userID);
		return count;
	}
	
	public double totalEarning(String userID) throws SQLException {
		double earning = 0;
		earning = serviceProviderAuthenticationDao.calculateEarning(userID);
		return earning;
	}
}
