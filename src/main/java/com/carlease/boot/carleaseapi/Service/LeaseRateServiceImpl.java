package com.carlease.boot.carleaseapi.Service;

import org.springframework.stereotype.Service;
import com.carlease.boot.carleaseapi.Request.LeaseRequest;


@Service
public class LeaseRateServiceImpl implements LeaseRateService {



	@Override
	public Double calculateLeaseRate(LeaseRequest leaseRate) {
		Long mileage = (leaseRate.getMileage() / 12) *leaseRate.getDuration();
		Double mileagNetPrice= (double) (mileage/leaseRate.getNetPrice());
		Double interest =  leaseRate.getInterestRate() / 100 ;
		Double netPriceInrest= (interest *leaseRate.getNetPrice())/12;
		return mileagNetPrice+netPriceInrest;
	}

}
