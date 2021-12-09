package com.servicegenie;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.servicegenie.daos.ViewServicesDao;
import com.servicegenie.model.ServiceProviderServices;
import com.servicegenie.services.ViewServicesService;

//author
//Abhishek Pareshbhai Pethani
//B00899521

class ViewServicesServiceTest {

	@Test
	void checkViewServicesServiceTest() {
		assertNotNull(new ViewServicesService());
	}

	@Test
	void getServicesTest() throws SQLException {
		List<ServiceProviderServices> services = new ArrayList<ServiceProviderServices>();
		ServiceProviderServices service = new ServiceProviderServices();
		service.setServiceID("1");
		service.setServiceName("AC cleaning");
		service.setServiceDescription("Good AC service cleaning");
		service.setServicePrice(100.0);
		services.add(service);
		
		service.setServiceID("2");
		service.setServiceName("Room cleaning");
		service.setServiceDescription("Good Room cleaning");
		service.setServicePrice(200.0);
		services.add(service);
		
		ViewServicesDao viewServicesDaoMock = Mockito.mock(ViewServicesDao.class);
		Mockito.when(viewServicesDaoMock.getAllServices("dalhousie11")).thenReturn(services);
		
		ViewServicesService viewServicesService = new ViewServicesService();
		viewServicesService.setViewServicesService(viewServicesDaoMock);
		int lengthOfResult = viewServicesService.getServices("dalhousie11").size();
		
		assertEquals(2, lengthOfResult);	
	}

}
