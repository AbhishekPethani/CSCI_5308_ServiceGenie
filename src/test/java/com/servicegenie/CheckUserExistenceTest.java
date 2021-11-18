//package com.servicegenie;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.sql.SQLException;
//
//import org.junit.jupiter.api.Test;
//
//import com.servicegenie.CheckUserExistence;
//
//class CheckUserExistenceTest {
//	CheckUserExistence validate = new CheckUserExistence();
//
//	@Test
//	void testCheckDatabaseSuccess() throws SQLException {
//		assertTrue(validate.CheckDatabase("1","admin"));
//	}
//	
//	@Test
//	void testCheckDatabaseFailure() throws SQLException {
//		assertFalse(validate.CheckDatabase("0","admin"));
//	}
//
//
//}
