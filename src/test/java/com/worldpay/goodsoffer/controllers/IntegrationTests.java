package com.worldpay.goodsoffer.controllers;

import java.util.Date;

import javax.validation.ValidationException;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.worldpay.goodsoffer.controller.OffersController;
import com.worldpay.goodsoffer.model.Offers;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTests {

  @Autowired
  OffersController offersController;

  @Test
  public void testCreateReadDelete() {
	Offers offer = new Offers(1,"Sky", "TV Offer", 39.99, "Eur", new Date(), 50, false);

	Offers offerResult = offersController.createOffer(offer);

    Iterable<Offers> offers = offersController.readActiveOffers();
    Assertions.assertThat(offers).first().hasFieldOrPropertyWithValue("name", "Sky");

    offersController.deleteOffer(offerResult.getId());
    Assertions.assertThat(offersController.readActiveOffers()).isEmpty();

  }

  @Test(expected = ValidationException.class)
  public void errorHandlingValidationExceptionThrown() {
	  offersController.wrongUrl();

  }
}
