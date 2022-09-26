package com.carlease.boot.carleaseapi.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlease.boot.carleaseapi.Entity.Car;
import com.carlease.boot.carleaseapi.Entity.Customer;
import com.carlease.boot.carleaseapi.Exception.ResourceNotFoundException;
import com.carlease.boot.carleaseapi.Repository.CarRepository;
import com.carlease.boot.carleaseapi.Repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {		
		
		return customerRepository.findAll();
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer update(Customer customer) {
		 customerRepository.findById(customer.getCustomerId())
	                .orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id: " + customer.getCustomerId()));

		return customerRepository.save(customer);
	}



	@Override
	public boolean delete(Integer id) {
		 Customer customer = customerRepository.findById(id)
         .orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id: " + id));
		customerRepository.delete(customer);
		return true;
	}


}
