package com.servicegenie.models;

public class Reviews {


	private String reviewId;
	private String serviceId;	
	private String customerEmail;
	private String reviewDescription;
	private String reviewStar;

	public Reviews(String reviewId, String serviceId, String customerEmail,String reviewDescription,String reviewStar) {
		this.reviewId = reviewId;
		this.serviceId = serviceId;
		this.customerEmail = customerEmail;
		this.reviewDescription = reviewDescription;
		this.reviewStar = reviewStar;
	}

    public String getReviewId () {
    	return reviewId;
	}

	public void setReviewId (String reviewId) {
		this.reviewId = reviewId;
	}

	public String getServiceId () {
		return serviceId;
	}

	public void setServiceId (String serviceId) {
		this.serviceId = serviceId;
	}

	public String getCustomerEmail () {
		return customerEmail;
	}

	public void setCustomerEmail (String customerEmail) {
	    this.customerEmail = customerEmail;
	}

	public String getReviewDescription () {
	    return reviewDescription;
	}

	public void setReviewDescription (String reviewDescription) {
	    this.reviewDescription = reviewDescription;
	}
	
	public String getReviewStar () {
	    return reviewStar;
	}

	public void setReviewStar (String reviewStar) {
	    this.reviewStar = reviewStar;
	}

}
