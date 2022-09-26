package com.carlease.boot.carleaseapi.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlease.boot.carleaseapi.Entity.Car;
import com.carlease.boot.carleaseapi.Repository.CarRepository;


@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarRepository carRepository;

	@Override
	public List<Car> getAllCars() {		
		
		return carRepository.findAll();
	}

}
