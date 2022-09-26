package com.carlease.boot.carleaseapi.Service;

import java.util.List;

import com.carlease.boot.carleaseapi.Entity.Customer;


public interface CustomerService {

	List<Customer> getAllCustomers();

	Customer save(Customer customer);
	
	Customer update(Customer customer);
	
	boolean delete(Integer id);
	
}
