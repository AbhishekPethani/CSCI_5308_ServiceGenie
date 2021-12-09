//Author
//Kandarp Sharad Parikh
//B00873863

package com.servicegenie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.servicegenie.services.ServiceProviderAuthenticationService;



public class ServiceProviderAuthenticationTest {
	ServiceProviderAuthenticationService authenticate = new ServiceProviderAuthenticationService();
	
	//Test to check if the class is not null
	@Test
	void ServiceProviderAuthenticationNotNull(){
		assertNotNull(authenticate);
	}
	
	//Test to check successful authentication
	@Test
	void validateUserSuccessfullTest() throws SQLException{
		assertThat(authenticate.validateUser("dalhousie11", "dal") == "ServiceProviderHomePage.html");
	}
	
	//Test to check failed authentication
	@Test
	void validateUserFailureTest() throws SQLException{
		assertThat(authenticate.validateUser("wrong-username", "wrongpassword") == "LoginFailed.html");
	}

}
