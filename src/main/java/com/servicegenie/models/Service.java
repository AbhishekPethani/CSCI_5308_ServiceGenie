package com.servicegenie.models;

public class Service {
    private String serviceID;
    private String serviceProviderID;
    private String serviceName;
    private String serviceDescription;
    private Double servicePrice;

    public Service(String serviceID, String serviceProviderID, String serviceName, String serviceDescription, Double servicePrice) {
        this.serviceID = serviceID;
        this.serviceProviderID = serviceProviderID;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.servicePrice = servicePrice;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceProviderID() {
        return serviceProviderID;
    }

    public void setServiceProviderID(String serviceProviderID) {
        this.serviceProviderID = serviceProviderID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public Double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Double servicePrice) {
        this.servicePrice = servicePrice;
    }
}
