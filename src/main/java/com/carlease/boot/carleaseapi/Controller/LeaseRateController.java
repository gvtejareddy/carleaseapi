package com.carlease.boot.carleaseapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlease.boot.carleaseapi.Request.LeaseRequest;
import com.carlease.boot.carleaseapi.Response.Response;
import com.carlease.boot.carleaseapi.Service.LeaseRateService;

@RestController
@RequestMapping("lease")
public class LeaseRateController {
	
	@Autowired
	private LeaseRateService leaseRateService;
	
	
	@PostMapping("/calculateLease")
	public ResponseEntity<Response> calculateLease(@RequestBody LeaseRequest leaseRequest) {
		String message="";
        try {
        	Double leaseRate =leaseRateService.calculateLeaseRate(leaseRequest);
            return ResponseEntity.status(HttpStatus.OK).body(new Response(leaseRate.toString()));
        } catch (Exception e) {
            message = "Order Save Failed" ;
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Response(message));
        }
		
		
		
		
		
	}
	

}
