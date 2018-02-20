package com.idealo.offer;

import java.util.Optional;

public interface OfferService {
    Optional<Offer> getOffer(String itemName);
}
