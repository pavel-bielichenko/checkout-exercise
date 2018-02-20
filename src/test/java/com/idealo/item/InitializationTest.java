package com.idealo.item;

import com.idealo.CheckoutApplication;
import com.idealo.offer.Offer;
import com.idealo.offer.repository.OfferRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.idealo.CheckoutApplication.ITEMS;
import static org.hamcrest.Matchers.containsInAnyOrder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CheckoutApplication.class})
@SpringBootTest
@DirtiesContext
public class InitializationTest {

    @Autowired
    protected OfferRepository offerRepository;

    @Test
    public void repositoryShouldBeInitialized() {
        Iterable<Offer> persisted = offerRepository.findAll();
        Assert.assertThat(persisted, containsInAnyOrder(ITEMS.toArray()));
    }
}
