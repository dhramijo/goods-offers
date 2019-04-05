package com.worldpay.goodsoffer;

import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.worldpay.goodsoffer.model.Offers;

public class SystemTests {

  @Test
  public void testCreateReadDelete() {
	  
    RestTemplate restTemplate = new RestTemplate();

    String url = "http://localhost:8080/offer";
    Offers offer = new Offers(1,"Sky", "TV Offer", 39.99, "Eur", new Date(), 50, false);
    ResponseEntity<Offers> entity = restTemplate.postForEntity(url, offer, Offers.class);

    Offers[] offers = restTemplate.getForObject(url, Offers[].class);
    Assertions.assertThat(offers).extracting(Offers::isExpired).containsOnly(false);

    restTemplate.delete(url + "/" + entity.getBody().getId());
    Assertions.assertThat(restTemplate.getForObject(url, Offers[].class)).isEmpty();
  }

  @Test
  public void testErrorHandlingReturnsBadRequest() {

    RestTemplate restTemplate = new RestTemplate();

    String url = "http://localhost:8080/wrong_url";

    try {
      restTemplate.getForEntity(url, String.class);
    } catch (HttpClientErrorException e) {
      Assert.assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
    }
  }

}
