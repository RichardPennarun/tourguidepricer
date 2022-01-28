package com.tourguide.pricer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tourguide.pricer.model.TripDeal;
import com.tourguide.pricer.model.TripRequest;
import com.tourguide.pricer.repository.TripDealRepository;
import com.tourguide.pricer.repository.TripRequestRepository;

@Service
public class PricerService {

	@Autowired
	private TripRequestRepository tripRequestRepository;

	@Autowired
	private TripDealRepository tripDealRepository;
	
	private TripPricer tripPricer = new TripPricer();

	public List<TripDeal> getTripDeals(TripRequest tripRequest) {
		
		// Enregistre la requete
		tripRequestRepository.save(tripRequest);
		
		// Obtient des deals pour la requête
		List<TripDeal> tripDeals = tripPricer.getPrice(tripRequest);
		
		// Enregistre les deals
		for(TripDeal tripDeal : tripDeals) {
			tripDealRepository.save(tripDeal);
		}
		return tripDeals;
	}
	
}





