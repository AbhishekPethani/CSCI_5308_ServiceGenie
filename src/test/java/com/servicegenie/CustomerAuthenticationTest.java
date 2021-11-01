package com.servicegenie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.servicegenie.CustomerAuthentication;

class CustomerAuthenticationTest {

	@Test
	void ValidateUserSuccessTest() throws SQLException {
		CustomerAuthentication auth = new CustomerAuthentication();
		assertThat(auth.ValidateUser("1", "Kandarp").equals("redirect:UserHomePage.html"));
	}

	@Test
	void ValidateUserFailueTest() throws SQLException {
		CustomerAuthentication auth = new CustomerAuthentication();
		assertThat(auth.ValidateUser("0", "Kandarp").equals("redirect:LoginFailed.html"));
	}
}
