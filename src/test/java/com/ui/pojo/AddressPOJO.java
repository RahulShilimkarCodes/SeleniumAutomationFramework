package com.ui.pojo;

import org.openqa.selenium.By;

public class AddressPOJO {
	
	private String company;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;
	private String homePhone;
	private String mobilePhone;
	private String additionalInfo;
	private String addressTitle;
	
	public AddressPOJO( String company, String addressLine1, String addressLine2,
			String city, String state, String zipCode, String homePhone, String mobilePhone, String additionalInfo,
			String addressTitle) {
		this.company = company;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.additionalInfo = additionalInfo;
		this.addressTitle = addressTitle;
	}
	

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
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
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public String getAddressTitle() {
		return addressTitle;
	}
	public void setAddressTitle(String addressTitle) {
		this.addressTitle = addressTitle;
	}
	
	@Override
	public String toString() {
		return "AddressPOJO [company=" + company
				+ ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state="
				+ state + ", zipCode=" + zipCode + ", homePhone=" + homePhone + ", mobilePhone=" + mobilePhone
				+ ", additionalInfo=" + additionalInfo + ", addressTitle=" + addressTitle + "]";
	}
	



}
