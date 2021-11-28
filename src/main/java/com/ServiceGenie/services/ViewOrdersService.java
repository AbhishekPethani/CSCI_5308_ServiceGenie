package com.servicegenie.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.servicegenie.daos.ViewOrdersDao;
import com.servicegenie.daos.ViewServicesByServiceProviderDao;

//Author
//Kandarp Sharad Parikh
//B00873863

//Class to facilitate the functionality of viewing orders
@Service
public class ViewOrdersService {
	
	private ViewOrdersDao orders;

	public ViewOrdersService() throws SQLException {
		ViewOrdersDao orders = new ViewOrdersDao();
		this.orders = orders;
		}
	
	
	//Function to get the list of service providers which will be used to populate the dropdown menu
	public List<String> getListOfServiceProviders() throws SQLException
	{
		ResultSet rs = this.orders.getServiceProviderId();
		List<String> serviceProvidersList = new ArrayList<String>();
		while(rs.next()) {
			serviceProvidersList.add(rs.getString("ServiceProviderID"));
		}
		List<String> uniqueServiceProviders = serviceProvidersList.stream().distinct().collect(Collectors.toList());
		
		return uniqueServiceProviders;
	}
	
	
	//Function to get the list of customers providers which will be used to populate the dropdown menu
	public List<String> getListOfCustomers() throws SQLException
	{
		ResultSet rs = this.orders.getCustomersId();
		List<String> customersList = new ArrayList<String>();
		while(rs.next()) {
			customersList.add(rs.getString("Customer_Email"));
		}
		List<String> uniquecustomers = customersList.stream().distinct().collect(Collectors.toList());
		
		return uniquecustomers;
	}
	
	
	//Function to get all the orders
	public List<ArrayList<String>> getAllOrders() throws SQLException
	{
		ResultSet rs = this.orders.getAllOrders();
		List<ArrayList<String>> listOforders = new ArrayList<ArrayList<String>>();
		//ArrayList<String> orders = new ArrayList<String>();
		while(rs.next()) {
			ArrayList<String> orders = new ArrayList<String>();
			System.out.println(orders);
			orders.add(rs.getString("order_id"));
			orders.add(rs.getString("customer_id"));
			orders.add(rs.getString("service_provider_id"));
			orders.add(rs.getString("order_amount"));
			orders.add(rs.getString("order_date"));
			orders.add(rs.getString("service_name"));
			System.out.println(orders);
			listOforders.add(orders);
			System.out.println(listOforders);
		}
		System.out.println(listOforders);
		return listOforders;
	}
	
	
	//Function to get all the orders based on the Service Provider
	public List<ArrayList<String>> viewOrdersByServiceProviders(String serviceProvider) throws SQLException
	{
		List<ArrayList<String>> listOforders = new ArrayList<ArrayList<String>>();
		ResultSet rs = this.orders.getOrdersByServiceProvider(serviceProvider);
		//ArrayList<String> orders = new ArrayList<String>();
		while(rs.next()) {
			ArrayList<String> orders = new ArrayList<String>();
			System.out.println(orders);
			orders.add(rs.getString("order_id"));
			orders.add(rs.getString("customer_id"));
			orders.add(rs.getString("order_amount"));
			orders.add(rs.getString("order_date"));
			orders.add(rs.getString("service_name"));
			listOforders.add(orders);
			System.out.println(listOforders);
		}
		System.out.println(listOforders);
		return listOforders;

	}
	
	
	//Function to get all the orders based on the customerID
	public List<ArrayList<String>> viewOrdersByCustomer(String customerid) throws SQLException
	{
		List<ArrayList<String>> listOforders = new ArrayList<ArrayList<String>>();
		ResultSet rs = this.orders.getOrdersByCustomer(customerid);
		//ArrayList<String> orders = new ArrayList<String>();
		while(rs.next()) {
			ArrayList<String> orders = new ArrayList<String>();
			System.out.println(orders);
			orders.add(rs.getString("order_id"));
			orders.add(rs.getString("service_provider_id"));
			orders.add(rs.getString("order_amount"));
			orders.add(rs.getString("order_date"));
			orders.add(rs.getString("service_name"));
			listOforders.add(orders);
			System.out.println(listOforders);
		}
		System.out.println(listOforders);
		return listOforders;
	}
}
