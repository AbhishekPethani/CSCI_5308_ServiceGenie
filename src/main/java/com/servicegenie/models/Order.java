package com.servicegenie.models;

import java.util.Date;

public class Order {
    int orderID;
    String customerID;
    String serviceProviderID;
    Double orderAmount;
    Date orderDate;
    String serviceName;
    ServiceForCustomers serviceForCustomers;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getServiceProviderID() {
        return serviceProviderID;
    }

    public void setServiceProviderID(String serviceProviderID) {
        this.serviceProviderID = serviceProviderID;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public ServiceForCustomers getService() {
        return serviceForCustomers;
    }

    public void setService(ServiceForCustomers serviceForCustomers) {
        this.serviceForCustomers = serviceForCustomers;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", customerID='" + customerID + '\'' +
                ", orderAmount=" + orderAmount +
                ", orderDate=" + orderDate +
                ", service=" + serviceForCustomers +
                '}';
    }
}
