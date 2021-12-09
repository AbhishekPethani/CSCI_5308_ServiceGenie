package com.servicegenie;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.servicegenie.daos.ServiceProviderProfileDao;
import com.servicegenie.model.ServiceProviderProfile;
import com.servicegenie.services.ServiceProviderProfileService;

//author
//Abhishek Pareshbhai Pethani
//B00899521

class ServiceProviderProfileServiceTest {

	@Test
	void checkServiceProviderProfileServiceTest() {
		assertNotNull(new ServiceProviderProfileService());
	}
	
	@Test
	void getProfileTest() throws SQLException {
		ServiceProviderProfile profile = new ServiceProviderProfile();
		profile.setFirstName("DalOnline");
		profile.setLastName("Services");
		profile.setCategory("hardware");
		profile.setServiceDescription("We are specialized in all type of wooden hardware");
		profile.setEmail("dalonline@dal.ca");
		profile.setContactNumber("9784561023");
		profile.setApartmentNumber("741");
		profile.setStreetName("South Park");
		profile.setCity("Halifax");
		profile.setZipcode("A5A6B7");
		profile.setProvince("Nova Scotia");
		profile.setCountry("Canada");
		
		ServiceProviderProfileDao serviceProviderProfileDaoMock = Mockito.mock(ServiceProviderProfileDao.class);
		when(serviceProviderProfileDaoMock.getProfileByUserID("dalhousie11")).thenReturn(profile);
		
		ServiceProviderProfileService serviceProviderProfileService = new ServiceProviderProfileService();
		serviceProviderProfileService.setServiceProviderProfileService(serviceProviderProfileDaoMock);
		assertNotNull(serviceProviderProfileService.getProfile("dalhousie11"));
	}
}
