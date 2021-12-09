package com.servicegenie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.servicegenie.services.AddGrievanceService;

class AddGrievanceServiceTest {

	AddGrievanceService services;
	
	public AddGrievanceServiceTest()
	{
		this.services = new AddGrievanceService();
	}

	@Test
	public void NotNullTest() {
		assertNotNull(this.services);
	}
	
	@Test
	public void addGrievancesTest() {
		assertThat(this.services.addGrievances("","","") instanceof String);
	}

}
