package com.carlease.boot.carleaseapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlease.boot.carleaseapi.Entity.Customer;
import com.carlease.boot.carleaseapi.Response.Response;
import com.carlease.boot.carleaseapi.Service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	   @GetMapping("/all")
	    public ResponseEntity<List<Customer>> getAll() {
	        try {
	            return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	   
	   @PostMapping("/save")
	   public ResponseEntity<Response> save(@RequestBody Customer customer){
	        String message = "";
	        try {
	        	customerService.save(customer);
	            message = "Order successfully added: ";
	            return ResponseEntity.status(HttpStatus.OK).body(new Response(message));
	        } catch (Exception e) {
	            message = "Order Save Failed" ;
	            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Response(message));
	        }

	   }
	   
	   @PutMapping("/update")
	   public ResponseEntity<Response> update(@RequestBody Customer customer){
	        String message = "";
	        try {
	        	customerService.update(customer);
	            message = "Order successfully added: ";
	            return ResponseEntity.status(HttpStatus.OK).body(new Response(message));
	        } catch (Exception e) {
	            message = "Order Save Failed" ;
	            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Response(message));
	        }

	   }
	   
	   public ResponseEntity<Integer> deletePost(@PathVariable Integer id) {

		    var isRemoved = customerService.delete(id);

		    if (!isRemoved) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }

		    return new ResponseEntity<>(id, HttpStatus.OK);
		}
	   
}
