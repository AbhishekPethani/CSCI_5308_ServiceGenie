package com.servicegenie.models;

public class Greivances {

	public String ID;
	public String customerEmail;	
	public String serviceId;
	public String greivanceDescription;
	

	public Greivances(String ID, String customerEmail, String serviceId,String greivanceDescription) {
		this.ID = ID;
		this.customerEmail = customerEmail;
		this.serviceId = serviceId;
		this.greivanceDescription = greivanceDescription;
	}

    public String getGreivanceId () {
    	return ID ;
	}

	public void setGreivance (String grevanceId) {
		this.ID = grevanceId;
	}

	public String getCustomerEmail1 () {
		return customerEmail;
	}

	public void setCustomerEmail1 (String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getServiceId () {
		return serviceId;
	}

	public void setServiceId (String serviceId) {
	    this.serviceId = serviceId;
	}

	public String getGreivanceDescription () {
	    return greivanceDescription;
	}

	public void setGreivaceDescription (String greivanceDescription) {
	    this.greivanceDescription = greivanceDescription;
	}
	
	

}
