package com.carlease.boot.carleaseapi.Request;

import lombok.Data;

@Data
public class LeaseRequest {
	
	private Long mileage;
	private Long duration;
	private Double interestRate;
	private Long netPrice;
	
	
	public LeaseRequest(Long mileage, Long duration, Double interestRate, Long netPrice) {
		super();
		this.mileage = mileage;
		this.duration = duration;
		this.interestRate = interestRate;
		this.netPrice = netPrice;
	}
	public Long getMileage() {
		return mileage;
	}
	public void setMileage(Long mileage) {
		this.mileage = mileage;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public Double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	public Long getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(Long netPrice) {
		this.netPrice = netPrice;
	}

	
}
