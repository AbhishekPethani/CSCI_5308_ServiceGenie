package com.servicegenie;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import java.sql.SQLException;
import com.servicegenie.daos.AddServiceDao;
import com.servicegenie.model.ServiceProviderServices;
import com.servicegenie.services.AddServiceService;

//author
//Abhishek Pareshbhai Pethani
//B00899521

class AddServiceServiceTest {

	@Test
	void checkAddServiceServiceClassExist() {
		assertNotNull(new AddServiceService());
	}

	@Test
	void addServiceTest() throws SQLException{
		ServiceProviderServices service = new ServiceProviderServices();
		service.setServiceProviderID("dalhousie11");
		service.setServiceName("AC cleaning");
		service.setServiceDescription("Good AC service cleaning");
		service.setServicePrice(100.0);
		
		AddServiceDao addServiceDaoMock = Mockito.mock(AddServiceDao.class);
		Mockito.when(addServiceDaoMock.addServiceByUserID(service)).thenReturn("New Service added successfully");
		
		AddServiceService addServiceService = new AddServiceService();
		addServiceService.setAddServiceDao(addServiceDaoMock);
		String expectedResult = "New Service added successfully";
		assertEquals(expectedResult, addServiceService.addService(service));
	}
}
