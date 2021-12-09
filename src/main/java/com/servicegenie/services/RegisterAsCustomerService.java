//Author
//Kandarp Sharad Parikh
//B00873863

package com.servicegenie.services;

import java.sql.SQLException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.servicegenie.daos.RegisterAsCustomerDao;

//Class to register a new user as a customer
@Service
public class RegisterAsCustomerService
{	
	private RegisterAsCustomerDao customer;
	
	public RegisterAsCustomerService() throws SQLException
	{
		RegisterAsCustomerDao customer = new RegisterAsCustomerDao() ;
		this.customer = customer;
	}
	
	// Method to register a new Customer
	public void registerCustomer(String userID , String password) throws SQLException
	{
		customer.registerNewCustomer(userID, password);
	}
}

