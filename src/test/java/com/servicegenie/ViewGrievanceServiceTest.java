package com.servicegenie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.servicegenie.services.ViewGreivancesService;

public class ViewGrievanceServiceTest {

	ViewGreivancesService services;

	public ViewGrievanceServiceTest() throws SQLException {
		ViewGreivancesService services = new ViewGreivancesService();
		this.services = services;
	}

	@Test
	public void NotNullTest() {
		assertNotNull(this.services);
	}
	
	@Test
	public void getGreivancesTest() throws SQLException
	{
		assertThat(this.services.getGreivances() instanceof List);
	}
	
	

}
