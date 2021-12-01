package com.servicegenie;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;

import com.servicegenie.services.AdminAuthenticationService;

//Author
//Kandarp Sharad Parikh
//B00873863

public class AdminAuthenticationServiceTest {
	AdminAuthenticationService AdminObj = new AdminAuthenticationService();
	
	//Test to check if the class is not null
	@Test
	void AdminAuthenticationServiceNotNUll(){
		assertNotNull(AdminObj);
	}
	
	//Test to check that the return type of the validate User is String
	@Test
	void validateUserReturnTest() throws SQLException {
		ModelMap model = new ModelMap();
		assertThat(AdminObj.validateUser("1", "Kandarp",model) instanceof String);
	}
	
	//Test to check that login is successful for correct credentials
	@Test
	void validateUserLoginSucsessTest() throws SQLException {
		ModelMap model = new ModelMap();
		assertThat(AdminObj.validateUser("1", "Kandarp",model) == "AdminHomePage.html");
	}
	
	//Test to check that login is unsuccessful for incorrect credentials
	@Test
	void validateUserLoginFailureTest() throws SQLException {
		ModelMap model = new ModelMap();
		assertThat(AdminObj.validateUser("1", "WrongPassword",model) == "redirect:LoginFailed.html");
	}
	
	//Test to check that the ModelAttributes return the ModelMap object
	@Test
	void getModelAttributesTest() throws SQLException {
		ModelMap model = new ModelMap();
		assertThat(AdminObj.getModelAttributes(model) instanceof ModelMap);
	}
}
