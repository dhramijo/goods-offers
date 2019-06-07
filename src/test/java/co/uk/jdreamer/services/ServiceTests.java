package co.uk.jdreamer.services;

import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.uk.jdreamer.model.Offers;
import co.uk.jdreamer.service.OffersService;

@RunWith(SpringRunner.class)

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ServiceTests {

  @Autowired
  OffersService offersService;

  @Test
  public void testCreateReadDelete() {
	Offers offer = new Offers("Sky", "TV Offer", 39.99, "Eur", new Date(), 50, false);

	offersService.save(offer);

    Iterable<Offers> offers = offersService.findAll();
    Assertions.assertThat(offers).extracting(Offers::getName).containsOnly("Sky");

    offersService.deleteAll();
    Assertions.assertThat(offersService.findAll()).isEmpty();
  }
}
