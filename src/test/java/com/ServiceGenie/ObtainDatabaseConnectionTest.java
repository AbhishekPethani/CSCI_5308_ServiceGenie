package com.ServiceGenie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.servicegenie.ObtainDatabaseConnection;

class ObtainDatabaseConnectionTest {
	ObtainDatabaseConnection dbconnect = new ObtainDatabaseConnection();

	@Test
	void GetMyCOnnectionTest() {
		assertNotNull(dbconnect);
	}
	
	@Test
	void TerminateConnectionTest() throws SQLException {
		assertThat(dbconnect.TerminateConnection(dbconnect));
	}

}
