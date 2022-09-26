package com.carlease.boot.carleaseapi.Service;

import org.springframework.stereotype.Service;
import com.carlease.boot.carleaseapi.Request.LeaseRequest;


@Service
public class LeaseRateServiceImpl implements LeaseRateService {



	@Override
	public Double calculateLeaseRate(LeaseRequest leaseRate) {
		long mileage = (leaseRate.getMileage() / 12) *leaseRate.getDuration();
		long mileagNetPrice= mileage/leaseRate.getNetPrice();
		Double interest = ((( leaseRate.getInterestRate() / 100 )*leaseRate.getNetPrice())/12);
		return interest+mileagNetPrice;
	}

}
