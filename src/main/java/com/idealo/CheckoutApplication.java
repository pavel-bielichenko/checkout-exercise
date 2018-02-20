package com.idealo;

import com.google.common.collect.ImmutableList;
import com.idealo.offer.Offer;
import com.idealo.offer.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@ComponentScan("com.idealo")
@SpringBootApplication
@EntityScan(basePackageClasses = {CheckoutApplication.class, Jsr310JpaConverters.class})
@EnableJpaRepositories("com.idealo")
public class CheckoutApplication implements CommandLineRunner {

    public static final List ITEMS = ImmutableList
            .builder()
            .add(Offer.builder().itemName("A").itemPrice((double) 40).price((double) 100).quantity(3).build())
            .add(Offer.builder().itemName("B").itemPrice((double) (50)).price((double) 80).quantity(2).build())
            .add(Offer.builder().itemName("C").itemPrice((double) 25).build())
            .add(Offer.builder().itemName("D").itemPrice((double) 20).build())
            .build();

    @Autowired
    private OfferRepository offerRepository;

    public static void main(String[] args) {
        new SpringApplicationBuilder(CheckoutApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        offerRepository.save(ITEMS);
    }
}
