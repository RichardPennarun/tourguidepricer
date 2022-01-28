package com.tourguide.pricer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tourguide.pricer.model.TripDeal;
import com.tourguide.pricer.model.TripRequest;
import com.tourguide.pricer.service.PricerService;


@RestController
public class PricerController {

	@Autowired
	PricerService pricerService;

	/*
	 * Post - Get a list of trip deals for an attraction 
	 * and user preferences along in a trip request
	 * @param An object tripRequest
	 * @return A list of objects TripDeal
	 */
	@PostMapping("/getTripDeals")
	public List<TripDeal> getTripDeals(@RequestBody TripRequest tripRequest) {
		List<TripDeal> tripDeals = pricerService.getTripDeals(tripRequest);
		return tripDeals;
	}
	
}
