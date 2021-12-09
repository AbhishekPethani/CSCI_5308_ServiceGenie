package com.servicegenie.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.servicegenie.model.ServiceProviderOrders;

//author
//Abhishek Pareshbhai Pethani
//B00899521

public class ServiceProviderOrderDao {
	
	public List<ServiceProviderOrders> getOrdersByUserID(String userID) throws SQLException {
		// Obtain Database connection and get all orders of current service provider
		Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
		
		// list of ServiceProviderOrder to store all the orders of current service provider
		List<ServiceProviderOrders> orders = new ArrayList<ServiceProviderOrders>();
		
		try {
			// execute sql query
			Statement sql = myDBConnect.createStatement();
			ResultSet result = sql.executeQuery("Select order_id, service_name, customer_id, order_amount, order_date from orders where service_provider_id= '" +userID + "' and processed_status= '0';");	
			// fetch the data from ResultSet object
			while(result.next()) {
				String orderID = result.getString("order_id");
				String serviceName = result.getString("service_name");
				String customerID = result.getString("customer_id");
				String orderAmount = result.getString("order_amount");
				String orderDate = result.getString("order_date");
				ServiceProviderOrders order = new ServiceProviderOrders(orderID, serviceName, customerID, orderAmount, orderDate);
				orders.add(order);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return orders;
	}

	public boolean processOrdersByOrderID(String orderID) throws SQLException {
		// Obtain Database connection and get all orders of current service provider
		Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
		try {
			String processOrderQuery = "update orders set processed_status = '1' where order_id= '"+ orderID +"';";
			// execute sql query
			Statement sql = myDBConnect.createStatement();
			sql.executeUpdate(processOrderQuery);
			return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public List<ServiceProviderOrders> getProcessedOrdersByUserID(String userID) throws SQLException {
		// Obtain Database connection and get all orders of current service provider
		Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
		
		// list of ServiceProviderOrder to store all the orders of current service provider
		List<ServiceProviderOrders> orders = new ArrayList<ServiceProviderOrders>();
		
		try {
			// execute sql query
			Statement sql = myDBConnect.createStatement();
			ResultSet result = sql.executeQuery("Select order_id, service_name, customer_id, order_amount, order_date from orders where service_provider_id= '" +userID + "' and processed_status= '1';");	
			// fetch the data from ResultSet object
			while(result.next()) {
				String orderID = result.getString("order_id");
				String serviceName = result.getString("service_name");
				String customerID = result.getString("customer_id");
				String orderAmount = result.getString("order_amount");
				String orderDate = result.getString("order_date");
				ServiceProviderOrders order = new ServiceProviderOrders(orderID, serviceName, customerID, orderAmount, orderDate);
				orders.add(order);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return orders;
	}
}
