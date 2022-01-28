package com.tourguide.pricer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Currency;
import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tourguide.pricer.model.TripDeal;
import com.tourguide.pricer.model.TripRequest;


@SpringBootTest
public class ModelTest {
	
	@Test
	public void getTripRequestTest() {
		TripRequest tr = new TripRequest();
		final Date requestDate = new Date();
		final UUID uuid = UUID.randomUUID();
		final int userRewardPoints = 75;
		final UUID uuid2 = UUID.randomUUID();
		final String attractionName = "Disneyland";
		final int attractionRewardpoints= 15;
		final Currency currency = null;
		final int nightsStay = 4;
		final int numberOfAdults = 2;
		final int numberOfChildren = 2;
		tr.setRequestDate(requestDate);
		tr.setUserId(uuid);
		tr.setUserRewardPoints(userRewardPoints);
		tr.setAttractionId(uuid2);
		tr.setAttractionName(attractionName);
		tr.setAttractionRewardpoints(attractionRewardpoints);
		tr.setCurrency(currency);
		tr.setNightsStay(4);
		tr.setNumberOfAdults(2);
		tr.setNumberOfChildren(2);
		assertThat(tr.getRequestDate()).isEqualTo(requestDate);
		assertThat(tr.getUserId()).isEqualTo(uuid);
		assertThat(tr.getUserRewardPoints()).isEqualTo(userRewardPoints);
		assertThat(tr.getAttractionId()).isEqualTo(uuid2);
		assertThat(tr.getAttractionName()).isEqualTo(attractionName);
		assertThat(tr.getAttractionRewardpoints()).isEqualTo(attractionRewardpoints);
		assertThat(tr.getCurrency()).isEqualTo(currency);
		assertThat(tr.getNightsStay()).isEqualTo(nightsStay);
		assertThat(tr.getNumberOfAdults()).isEqualTo(numberOfAdults);
		assertThat(tr.getNumberOfChildren()).isEqualTo(numberOfChildren);
	}
	
	@Test
	public void setTripRequestTest() {
		final UUID id = UUID.randomUUID();
		final Date requestDate = new Date();
		final UUID uuid = UUID.randomUUID();
		final int userRewardPoints = 25;
		final UUID uuid2 = UUID.randomUUID();
		final String attractionName = "Disneyland";
		final int attractionRewardpoints = 15;
		final Currency currency = null;
		final int nightsStay = 4;
		final int numberOfAdults = 2;
		final int numberOfChildren = 2;
		
		TripRequest tripRequest = new TripRequest(id, requestDate, uuid, userRewardPoints, uuid2, attractionName, 
				attractionRewardpoints, currency, nightsStay, numberOfAdults, numberOfChildren);
		assertThat(tripRequest.getId()).isEqualTo(id);
		assertThat(tripRequest.getRequestDate()).isEqualTo(requestDate);
		assertThat(tripRequest.getUserId()).isEqualTo(uuid);
		assertThat(tripRequest.getUserRewardPoints()).isEqualTo(userRewardPoints);
		assertThat(tripRequest.getAttractionId()).isEqualTo(uuid2);
		assertThat(tripRequest.getAttractionName()).isEqualTo(attractionName);
		assertThat(tripRequest.getAttractionRewardpoints()).isEqualTo(attractionRewardpoints);
		assertThat(tripRequest.getCurrency()).isEqualTo(currency);
		assertThat(tripRequest.getNightsStay()).isEqualTo(nightsStay);
		assertThat(tripRequest.getNumberOfAdults()).isEqualTo(numberOfAdults);
		assertThat(tripRequest.getNumberOfChildren()).isEqualTo(numberOfChildren);
	}
	
	@Test
	public void getTripDealTest() {
		TripDeal td = new TripDeal();
		final UUID uuid = UUID.randomUUID();
		final UUID uuid2 = UUID.randomUUID();
		final String attractionName = "Disneyland";
		final String providerName = "Blue Sky";
		final double price= 500;
		final Currency currency = null;
		final int nightsStay = 4;
		final int numberOfAdults = 2;
		final int numberOfChildren = 2;
		final Date tripDealDate = new Date();
		td.setUserId(uuid);
		td.setAttractionId(uuid2);
		td.setAttractionName(attractionName);
		td.setProviderName(providerName);
		td.setPrice(price);
		td.setCurrency(currency);
		td.setNightsStay(4);
		td.setNumberOfAdults(2);
		td.setNumberOfChildren(2);
		td.setTripDealDate(tripDealDate);
		assertThat(td.getUserId()).isEqualTo(uuid);
		assertThat(td.getAttractionId()).isEqualTo(uuid2);
		assertThat(td.getAttractionName()).isEqualTo(attractionName);
		assertThat(td.getProviderName()).isEqualTo(providerName);
		assertThat(td.getPrice()).isEqualTo(price);
		assertThat(td.getCurrency()).isEqualTo(currency);
		assertThat(td.getNightsStay()).isEqualTo(nightsStay);
		assertThat(td.getNumberOfAdults()).isEqualTo(numberOfAdults);
		assertThat(td.getNumberOfChildren()).isEqualTo(numberOfChildren);
		assertThat(td.getTripDealDate()).isEqualTo(tripDealDate);
	}
	
	@Test
	public void setTripDealTest() {
		final UUID id = UUID.randomUUID();
		final UUID uuid = UUID.randomUUID();
		final UUID uuid2 = UUID.randomUUID();
		final String attractionName = "Disneyland";
		final String providerName = "Blue Sky";
		final double price= 500;
		final Currency currency = null;
		final int nightsStay = 4;
		final int numberOfAdults = 2;
		final int numberOfChildren = 2;
		final Date tripDealDate = new Date();
		
		TripDeal tripDeal = new TripDeal(id, uuid, uuid2, attractionName, providerName, 
				price, currency, nightsStay, numberOfAdults, numberOfChildren, tripDealDate);
		assertThat(tripDeal.getId()).isEqualTo(id);
		assertThat(tripDeal.getUserId()).isEqualTo(uuid);
		assertThat(tripDeal.getAttractionId()).isEqualTo(uuid2);
		assertThat(tripDeal.getAttractionName()).isEqualTo(attractionName);
		assertThat(tripDeal.getProviderName()).isEqualTo(providerName);
		assertThat(tripDeal.getPrice()).isEqualTo(price);
		assertThat(tripDeal.getCurrency()).isEqualTo(currency);
		assertThat(tripDeal.getNightsStay()).isEqualTo(nightsStay);
		assertThat(tripDeal.getNumberOfAdults()).isEqualTo(numberOfAdults);
		assertThat(tripDeal.getNumberOfChildren()).isEqualTo(numberOfChildren);
		assertThat(tripDeal.getTripDealDate()).isEqualTo(tripDealDate);
	}

}
