package com.idealo.offer.repository;

import com.idealo.offer.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, String> {
    Optional<Offer> findByItemName(String itemName);
}
