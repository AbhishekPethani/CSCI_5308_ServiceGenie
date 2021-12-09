package com.servicegenie.model;

//author
//Abhishek Pareshbhai Pethani
//B00899521

public class ServiceProviderOrders {
	private String orderID;
	private String serviceName;
	private String customerID;
	private String orderAmount;
	private String orderDate;
	
	public ServiceProviderOrders(String orderID, String serviceName, String customerID, String orderAmount, String orderDate) {
		this.orderID = orderID;
		this.serviceName = serviceName;
		this.customerID = customerID;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
		
}
