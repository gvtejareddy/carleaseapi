package com.carlease.boot.carleaseapi.Response;

import lombok.Data;

@Data
public class CarResponse {
	
	private Integer carId;
	private String make;
	private String model;
	private Integer version;
	private Integer doors;
	private String emission;
	private Integer grossPrice;
	private Integer netPrice;
	
	

}
