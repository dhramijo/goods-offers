package com.worldpay.goodsoffer.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worldpay.goodsoffer.model.Offers;

public interface OffersService extends JpaRepository<Offers, Integer> {
	
}

