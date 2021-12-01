package com.servicegenie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.servicegenie.services.CheckUserExistenceService;

//Author
//Kandarp Sharad Parikh
//B00873863

class CheckUserExistenceTest {
	CheckUserExistenceService validate = new CheckUserExistenceService();
	
	//Test to check that the class is not null
	@Test
	void CheckUserExistenceServiceNotNUll() {
		assertNotNull(validate);
	}

	//Test to check if the user existence is true , which denotes that the user of type exists
	@Test
	void CheckDatabaseSuccessTest() throws SQLException {
		assertTrue(validate.checkDatabase("1","admin"));
	}
	
	//Test to check the if user existence is false , which denotes that the user of type does not exists
	@Test
	void testCheckDatabaseFailureTest() throws SQLException {
		assertFalse(validate.checkDatabase("5","admin"));
	}

}
