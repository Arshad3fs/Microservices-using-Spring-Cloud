package com.village.order.domain;

public class Address {
	private String houseNumber;
	private String streetName;
	private long postalCode;
	private String city;
	private String state;
	private String country;
	
	public Address() {}
	
	public Address(String houseNumber, String streetName, long postalCode, String city, String state, String country) {
		super();
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.postalCode = postalCode;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public long getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(long postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
