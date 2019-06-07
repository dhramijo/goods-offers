package co.uk.jdreamer;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.uk.jdreamer.controller.OffersController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OffersApplicationTests {
	
	@Autowired
	OffersController offersController;
	
	@Test
	public void contextLoads() {
		assertNotNull(offersController);
	}

}
