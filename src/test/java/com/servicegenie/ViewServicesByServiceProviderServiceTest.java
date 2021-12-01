package com.servicegenie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;

import com.servicegenie.services.ViewServicesByServiceProviderService;

//Author
//Kandarp Sharad Parikh
//B00873863


public class ViewServicesByServiceProviderServiceTest {
	ViewServicesByServiceProviderService viewServiceObj = new ViewServicesByServiceProviderService();
	public ViewServicesByServiceProviderServiceTest() throws SQLException {
		ViewServicesByServiceProviderService viewServiceObj = new ViewServicesByServiceProviderService();
		this.viewServiceObj = viewServiceObj;
	}
	
	//Test to check that the class is not null
	@Test
	void ViewServicesByServiceProviderServiceNotNull() {
		assertNotNull(this.viewServiceObj);
	}
	
	//Test to check that the services are retrievable
	@Test
	void getServiceDetailsTest() throws SQLException {
		String serviceProvider = "dalhousie11";
		ModelMap model = new ModelMap();
		assertThat(this.viewServiceObj.getServiceDetails(serviceProvider, model) instanceof List);
	}
	
	//Test to get the list of service providers
	@Test
	void getListOfServiceProvidersTest() throws SQLException {
		String serviceProvider = "dalhousie11";
		ModelMap model = new ModelMap();
		assertThat(this.viewServiceObj.getListOfServiceProviders() instanceof List);
	}
	
	
	

}
