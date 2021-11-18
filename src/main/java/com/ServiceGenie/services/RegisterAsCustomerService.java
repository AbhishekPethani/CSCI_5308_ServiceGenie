package com.servicegenie.services;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//Class to register a new user as a customer
@Service
public class RegisterAsCustomerService {
	
	private RegisterAsCustomerService registerascustomerservice;
	
	@RequestMapping(value = "/RegisterAsCustomer", method = RequestMethod.POST)
	public String RegisterAsACustomer(@RequestParam("customer-userid") String userId, @RequestParam("customer-password")String password) throws SQLException
	{
		return registerascustomerservice.RegisterAsACustomer(userId, password);
	}
}

