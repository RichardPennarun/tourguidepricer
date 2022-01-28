package com.tourguide.pricer.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.tourguide.pricer.model.TripDeal;
import com.tourguide.pricer.model.TripRequest;

@Service
public class TripPricer {
    public TripPricer() {
    }

    public List<TripDeal> getPrice(TripRequest tripRequest) {
        List<TripDeal> tripDeals = new ArrayList<TripDeal>();
        HashSet<String> tripDealsUsed = new HashSet<String>();

        try {
            TimeUnit.MILLISECONDS.sleep((long)ThreadLocalRandom.current().nextInt(1, 50));
        } catch (InterruptedException var16) {
        }

        for(int i = 0; i < 12; ++i) {
            int multiple = ThreadLocalRandom.current().nextInt(100, 700);
            double childrenDiscount = (double)(tripRequest.getNumberOfChildren() / 3);
            double price = (double)(multiple * tripRequest.getNumberOfAdults()) 
            		+ (double)multiple * childrenDiscount * (double)tripRequest.getNightsStay() 
            		+ 0.99D - (double)tripRequest.getUserRewardPoints();
            if (price < 0.0D) {
                price = 0.0D;
            }
            
            String providerName = "";

            do {
            	providerName = this.getProviderName();
            } while(tripDealsUsed.contains(providerName));

            tripDealsUsed.add(providerName);
            tripDeals.add(new TripDeal(UUID.randomUUID(), tripRequest.getUserId(), tripRequest.getAttractionId(), 
            		tripRequest.getAttractionName(), providerName, price, tripRequest.getCurrency(), 
            		tripRequest.getNightsStay(), tripRequest.getNumberOfAdults(), tripRequest.getNumberOfChildren(),
            		new Timestamp(System.currentTimeMillis())));
        }

        return tripDeals;
    }

    public String getProviderName() {
        int multiple = ThreadLocalRandom.current().nextInt(1, 13);
        switch(multiple) {
        case 1:
            return "Holiday Travels";
        case 2:
            return "Enterprize Ventures Limited";
        case 3:
            return "Sunny Days";
        case 4:
            return "FlyAway Trips";
        case 5:
            return "United Partners Vacations";
        case 6:
            return "Dream Trips";
        case 7:
            return "Live Free";
        case 8:
            return "Dancing Waves Cruselines and Partners";
        case 9:
            return "AdventureCo";
        case 10:
            return "Ride The waves";
        case 11:
            return "Enjoyin'";
        default:
            return "Cure-Your-Blues";
        }
    }
}
