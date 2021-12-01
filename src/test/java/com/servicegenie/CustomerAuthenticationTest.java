package com.servicegenie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.servicegenie.services.CustomerAuthenticationService;

//Author
//Kandarp Sharad Parikh
//B00873863

class CustomerAuthenticationTest {
	CustomerAuthenticationService auth = new CustomerAuthenticationService();
	
	//Test to check that the class is not null
	@Test
	void CustomerAuthenticationServiceNotNull() {
		assertNotNull(auth);
	}

	//Test to check the user validation is successful with correct credentials
	@Test
	void ValidateUserSuccessTest() throws SQLException {	
		assertThat(auth.validateUser("1", "Kandarp").equals("UserHomePage.html"));
	}

	//Test to check the user validation is unsuccessful with incorrect credentials
	@Test
	void ValidateUserFailueTest() throws SQLException {
		assertThat(auth.validateUser("0", "Kandarp").equals("LoginFailed.html"));
	}
}
