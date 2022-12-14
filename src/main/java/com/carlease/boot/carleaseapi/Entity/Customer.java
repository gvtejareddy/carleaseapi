package com.carlease.boot.carleaseapi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="customer")
public class Customer {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer customerId;
	private String name;
	private String street;
	private Integer houseNumber;
	private Integer zipCode;
	private String emailAddress;
	private Long phone;

	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Customer(Integer customerId, String name, String street, Integer houseNumber, Integer zipCode,
			String emailAddress, Long phone) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.street = street;
		this.houseNumber = houseNumber;
		this.zipCode = zipCode;
		this.emailAddress = emailAddress;
		this.phone = phone;
	}
	
	

}
