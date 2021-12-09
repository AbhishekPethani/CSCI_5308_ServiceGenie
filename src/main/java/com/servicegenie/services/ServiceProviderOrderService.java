package com.servicegenie.services;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Service;
import com.servicegenie.daos.ServiceProviderOrderDao;
import com.servicegenie.model.ServiceProviderOrders;

//author
//Abhishek Pareshbhai Pethani
//B00899521

@Service
public class ServiceProviderOrderService {
	// object of ServiceProviderOrderDao
	private ServiceProviderOrderDao serviceProviderOrderDao;
	
	public ServiceProviderOrderService() {
		serviceProviderOrderDao = new ServiceProviderOrderDao();
	}
	
	public void setServiceProviderOrderDao(ServiceProviderOrderDao serviceProviderOrderDao) {
		this.serviceProviderOrderDao = serviceProviderOrderDao;
	}

	public List<ServiceProviderOrders> getOrders(String userID) throws SQLException {
		// list of list to store all the orders of current service provider
		List<ServiceProviderOrders> orders = serviceProviderOrderDao.getOrdersByUserID(userID); 
		return orders;
	}
	
	public boolean processOrder(String orderID) throws SQLException {
		boolean isOrderProcessed;
		isOrderProcessed = serviceProviderOrderDao.processOrdersByOrderID(orderID);
		return isOrderProcessed;
	}
	
	public List<ServiceProviderOrders> getProcessesOrders(String userID) throws SQLException {
		// list of list to store all the orders of current service provider
		List<ServiceProviderOrders> orders = serviceProviderOrderDao.getProcessedOrdersByUserID(userID); 
		return orders;
	}
}
