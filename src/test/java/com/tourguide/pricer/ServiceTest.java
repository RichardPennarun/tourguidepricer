package com.tourguide.pricer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tourguide.pricer.model.TripDeal;
import com.tourguide.pricer.model.TripRequest;
import com.tourguide.pricer.service.PricerService;
import com.tourguide.pricer.service.TripPricer;

@SpringBootTest
public class ServiceTest {

	@Autowired
	private PricerService pricerService;

	@Autowired
	private TripPricer tripPricer;

	@BeforeEach
	private void setUp() {
	}
	

	
	
	
	
	@Test
	public void getPriceTest() {

		tripPricer = new TripPricer();
		
		final Date requestDate = new Date();
		final UUID uuid = UUID.randomUUID();
		final int userRewardPoints = 75;
		final UUID uuid2 = UUID.randomUUID();
		final String attractionName = "Disneyland";
		final int attractionRewardpoints = 15;
		final Currency currency = null;
		final int nightsStay = 4;
		final int numberOfAdults = 2;
		final int numberOfChildren = 2;

		TripRequest tr = new TripRequest();
		tr.setRequestDate(requestDate);
		tr.setUserId(uuid);
		tr.setUserRewardPoints(userRewardPoints);
		tr.setAttractionId(uuid2);
		tr.setAttractionName(attractionName);
		tr.setAttractionRewardpoints(attractionRewardpoints);
		tr.setCurrency(currency);
		tr.setNightsStay(nightsStay);
		tr.setNumberOfAdults(numberOfAdults);
		tr.setNumberOfChildren(numberOfChildren);

		List<TripDeal> tripDeals = tripPricer.getPrice(tr);

		for (TripDeal tripDeal : tripDeals) {
			assertThat(tripDeal.getUserId()).isEqualTo(uuid);
			assertThat(tripDeal.getAttractionId()).isEqualTo(uuid2);
			assertThat(tripDeal.getAttractionName()).isEqualTo("Disneyland");
			assertThat(tripDeal.getCurrency()).isEqualTo(null);
			assertThat(tripDeal.getNightsStay()).isEqualTo(4);
			assertThat(tripDeal.getNumberOfAdults()).isEqualTo(2);
			assertThat(tripDeal.getNumberOfChildren()).isEqualTo(2);
		}
	}

}
