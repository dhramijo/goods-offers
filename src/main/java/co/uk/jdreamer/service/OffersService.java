package co.uk.jdreamer.service;

import org.springframework.data.jpa.repository.JpaRepository;

import co.uk.jdreamer.model.Offers;

public interface OffersService extends JpaRepository<Offers, Integer> {
	
}

