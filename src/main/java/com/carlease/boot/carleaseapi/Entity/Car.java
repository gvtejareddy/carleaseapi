package com.carlease.boot.carleaseapi.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="car")
@Data
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer carId;
	private String make;
	private String model;
	private Integer version;
	private Integer doors;
	private String emission;
	private Integer grossPrice;
	private Integer netPrice;
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getDoors() {
		return doors;
	}
	public void setDoors(Integer doors) {
		this.doors = doors;
	}
	public String getEmission() {
		return emission;
	}
	public void setEmission(String emission) {
		this.emission = emission;
	}
	public Integer getGrossPrice() {
		return grossPrice;
	}
	public void setGrossPrice(Integer grossPrice) {
		this.grossPrice = grossPrice;
	}
	public Integer getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(Integer netPrice) {
		this.netPrice = netPrice;
	}
	
	
	
}
