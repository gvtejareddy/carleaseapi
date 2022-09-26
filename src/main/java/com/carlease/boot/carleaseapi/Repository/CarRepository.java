package com.carlease.boot.carleaseapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlease.boot.carleaseapi.Entity.Car;
import com.carlease.boot.carleaseapi.Entity.Customer;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer>{

}
