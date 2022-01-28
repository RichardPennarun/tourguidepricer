package com.tourguide.pricer.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourguide.pricer.model.TripRequest;

@Repository
public interface TripRequestRepository extends JpaRepository<TripRequest, UUID> {

}
