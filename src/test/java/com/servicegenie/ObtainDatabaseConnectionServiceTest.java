package com.servicegenie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.servicegenie.ObtainDatabaseConnection;
import com.servicegenie.services.ObtainDatabaseConnectionService;

//Author
//Kandarp Sharad Parikh
//B00873863


class ObtainDatabaseConnectionServiceTest {
	ObtainDatabaseConnectionService dbconnect = new ObtainDatabaseConnectionService();

	//Test to check if the class is not null
	@Test
	void GetMyConnectionNotNUllTest() {
		assertNotNull(dbconnect);
	}
	
	//Test to check that the connection is terminated
	@Test
	void TerminateConnectionTest() throws SQLException {
		assertThat(dbconnect.terminateConnection(dbconnect));
	}
	
	//Test to check that the ObtainDatabaseConnectionService returns the instance of Connection
	@Test
	void GetMyConnectionTest() throws SQLException {
		assertThat(dbconnect.getMyConnection() instanceof Connection);
	}

}
