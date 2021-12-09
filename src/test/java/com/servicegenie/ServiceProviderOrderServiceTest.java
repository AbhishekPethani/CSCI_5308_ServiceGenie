package com.servicegenie;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.servicegenie.daos.ServiceProviderOrderDao;
import com.servicegenie.services.ServiceProviderOrderService;
import com.servicegenie.model.ServiceProviderOrders;

//author
//Abhishek Pareshbhai Pethani
//B00899521

class ServiceProviderOrderServiceTest {

	@Test
	void checkServiceProviderOrderServiceClassExist() {
		assertNotNull(new ServiceProviderOrderService());
	}
	
	@Test
	void getOrdersTest() throws SQLException {
		List<ServiceProviderOrders> orders = new ArrayList<ServiceProviderOrders>();
		orders.add(new ServiceProviderOrders("1", "Hair Grooming", "abhishek171", "30", "11 November,2021"));
		orders.add(new ServiceProviderOrders("2", "Makeup", "dalhousie11", "100", "10 November,2021"));
		
		ServiceProviderOrderDao serviceProviderOrderDaoMock = Mockito.mock(ServiceProviderOrderDao.class);
		when(serviceProviderOrderDaoMock.getOrdersByUserID("dalhousie11")).thenReturn(orders);
		
		ServiceProviderOrderService serviceProviderOrderService = new ServiceProviderOrderService();
		serviceProviderOrderService.setServiceProviderOrderDao(serviceProviderOrderDaoMock);
		assertNotNull(serviceProviderOrderService.getOrders("dalhousie11"));
	}
	
	@Test
	void processOrderTest() throws SQLException {
		ServiceProviderOrderDao serviceProviderOrderDaoMock = Mockito.mock(ServiceProviderOrderDao.class);
		when(serviceProviderOrderDaoMock.processOrdersByOrderID("dalhousie11")).thenReturn(true);
		
		ServiceProviderOrderService serviceProviderOrderService = new ServiceProviderOrderService();
		serviceProviderOrderService.setServiceProviderOrderDao(serviceProviderOrderDaoMock);
		assertTrue(serviceProviderOrderService.processOrder("dalhousie11"));
	}
	
	@Test
	void getProcessesOrdersTest() throws SQLException {
		List<ServiceProviderOrders> orders = new ArrayList<ServiceProviderOrders>();
		orders.add(new ServiceProviderOrders("1", "Hair Grooming", "abhishek171", "30", "11 November,2021"));
		orders.add(new ServiceProviderOrders("2", "Makeup", "dalhousie11", "100", "10 November,2021"));
		
		ServiceProviderOrderDao serviceProviderOrderDaoMock = Mockito.mock(ServiceProviderOrderDao.class);
		when(serviceProviderOrderDaoMock.getProcessedOrdersByUserID("dalhousie11")).thenReturn(orders);
		
		ServiceProviderOrderService serviceProviderOrderService = new ServiceProviderOrderService();
		serviceProviderOrderService.setServiceProviderOrderDao(serviceProviderOrderDaoMock);
		assertNotNull(serviceProviderOrderService.getProcessesOrders("dalhousie11"));
	}

}
