package com.servicegenie.models;

public class ServiceForCustomers {
    private String serviceID;
    private String serviceProviderID;
    private String serviceName;
    private String serviceDescription;
    private Double servicePrice;
    private Integer offerID;
    private Offer offer;

    public ServiceForCustomers(String serviceID, String serviceProviderID, String serviceName, String serviceDescription, Double servicePrice, Offer offer, Integer offerID) {
        this.serviceID = serviceID;
        this.serviceProviderID = serviceProviderID;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.servicePrice = servicePrice;
        this.offerID = offerID;
        this.offer = offer;
    }

    public ServiceForCustomers() {}

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


    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceID='" + serviceID + '\'' +
                ", serviceProviderID='" + serviceProviderID + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", serviceDescription='" + serviceDescription + '\'' +
                ", servicePrice=" + servicePrice +
                ", offerID=" + offerID +
                ", offer= "+ offer +
                '}';
    }
}
