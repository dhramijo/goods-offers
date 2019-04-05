package com.worldpay.goodsoffer.controllers;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.worldpay.goodsoffer.controller.OffersController;
import com.worldpay.goodsoffer.model.Offers;
import com.worldpay.goodsoffer.service.OffersService;

@RunWith(SpringRunner.class)
@WebMvcTest(OffersController.class)
public class StandaloneControllerTests {

  @MockBean
  OffersService offersService;

  @Autowired
  MockMvc mockMvc;

  @Test
  public void testCreateReadDelete() throws Exception {
	Offers offer = new Offers(1,"Sky", "TV Offer", 39.99, "Eur", new Date(), 50, false);
    List<Offers> offers = Arrays.asList(offer);

    Mockito.when(offersService.findAll()).thenReturn(offers);

    mockMvc.perform(get("/offer"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", Matchers.hasSize(1)))
        .andExpect(jsonPath("$[0].name", Matchers.is("Sky")));
  }

}
