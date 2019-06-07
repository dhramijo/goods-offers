package co.uk.jdreamer.controllers;

import java.util.Date;

import javax.validation.ValidationException;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.uk.jdreamer.controller.OffersController;
import co.uk.jdreamer.model.Offers;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTests {

  @Autowired
  OffersController offersController;

  @Test
  public void testCreateReadDelete() {
	Offers offer = new Offers("Sky", "TV Offer", 39.99, "Eur", new Date(), 50, false);

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
