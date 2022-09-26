package com.carlease.boot.carleaseapi.Service;

import java.util.List;

import com.carlease.boot.carleaseapi.Entity.Car;
import com.carlease.boot.carleaseapi.Request.LeaseRequest;

public interface LeaseRateService {

	Double  calculateLeaseRate(LeaseRequest leaseRequest);
	
}
