//Author
//Kandarp Sharad Parikh
//B00873863

package com.servicegenie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.servicegenie.ObtainDatabaseConnection;
import com.servicegenie.daos.ObtainDatabaseConnectionDao;

class ObtainDatabaseConnectionDaoTest 
{
	Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();

	//Test to check if the class is not null
	@Test
	void GetMyConnectionNotNUllTest() 
	{
		assertNotNull(myDBConnect);
	}
	
	//Test to check that the ObtainDatabaseConnectionService returns the instance of Connection
	@Test
	void GetMyConnectionTest() throws SQLException 
	{
		assertThat(myDBConnect instanceof Connection);
	}
}
