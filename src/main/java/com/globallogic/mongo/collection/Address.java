package com.globallogic.mongo.collection;

public class Address {
	
	private String houseNumber;
	private String buildingName;
	private String street;
	private String city;
	private String state;
	private Integer pin;
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
	public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		this.pin = pin;
	}
	public Address(String houseNumber, String buildingName, String street, String city, String state, Integer pin) {
		super();
		this.houseNumber = houseNumber;
		this.buildingName = buildingName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pin = pin;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
