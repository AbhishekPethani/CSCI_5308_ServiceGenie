package com.servicegenie.model;

//author
//Abhishek Pareshbhai Pethani
//B00899521

public class ServiceProviderProfile {
	private String firstName;
	private String lastName;
	private String category;
	private String serviceDescription;
	private String email;
	private String contactNumber;
	private String apartmentNumber;
	private String streetName;
	private String city;
	private String zipcode;
	private String province;
	private String country;
	
	public ServiceProviderProfile() {
		
	}
	
	public ServiceProviderProfile(String firstName, String lastName, String category, String serviceDescription, String email, String contactNumber,
								  String apartmentNumber, String streetName, String city, String zipcode, String province, String country) {	
		this.firstName = firstName;
		this.lastName = lastName;
		this.category = category;
		this.serviceDescription = serviceDescription;
		this.email = email;
		this.contactNumber = contactNumber;
		this.apartmentNumber = apartmentNumber;
		this.streetName = streetName;
		this.city = city;
		this.zipcode = zipcode;
		this.province = province;
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
