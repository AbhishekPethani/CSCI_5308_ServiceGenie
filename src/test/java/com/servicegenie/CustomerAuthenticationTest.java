//Author
//Kandarp Sharad Parikh
//B00873863

package com.servicegenie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.servicegenie.daos.CustomerAuthenticationDao;
import com.servicegenie.services.CustomerAuthenticationService;

class CustomerAuthenticationTest 
{
	private CustomerAuthenticationService auth ;
	
	public CustomerAuthenticationTest() throws SQLException
	{
		CustomerAuthenticationService auth = new CustomerAuthenticationService();
		this.auth = auth;
	}
	//Test to check that the class is not null
	@Test
	void CustomerAuthenticationServiceNotNull() 
	{
		assertNotNull(auth);
	}

	//Test to check the user validation is successful with correct credentials
	@Test
	void validateUserSuccessTest() throws SQLException 
	{	
		assertTrue(auth.validateUser("MyUser", "password"));
	}

	//Test to check the user validation is unsuccessful with incorrect credentials
	@Test
	void validateUserFailueTest() throws SQLException 
	{
		assertFalse(auth.validateUser("0", "Kandarp"));
	}
}
