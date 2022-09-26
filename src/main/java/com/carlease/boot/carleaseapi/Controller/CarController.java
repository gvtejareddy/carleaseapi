package com.carlease.boot.carleaseapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlease.boot.carleaseapi.Entity.Car;
import com.carlease.boot.carleaseapi.Service.CarService;


@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	   @GetMapping("/all")
	    public ResponseEntity<List<Car>> getAll() {
	        try {
	            return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

}
