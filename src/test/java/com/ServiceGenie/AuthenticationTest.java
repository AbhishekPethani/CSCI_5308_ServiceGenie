package com.ServiceGenie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.servicegenie.Authentication;

class AuthenticationTest {

	@Test
	void ValidateUserSuccessTest() throws SQLException {
		Authentication auth = new Authentication();
		assertThat(auth.ValidateUser("1", "Kandarp").equals("redirect:UserHomePage.html"));
	}

	@Test
	void ValidateUserFailueTest() throws SQLException {
		Authentication auth = new Authentication();
		assertThat(auth.ValidateUser("0", "Kandarp").equals("redirect:LoginFailed.html"));
	}
}
