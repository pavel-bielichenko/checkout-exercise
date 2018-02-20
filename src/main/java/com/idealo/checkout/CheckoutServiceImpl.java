package com.idealo.checkout;

import com.idealo.offer.Offer;
import com.idealo.offer.OfferService;
import com.idealo.rest.dto.Item;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final OfferService offerService;

    @Override
    public Double calculateTotal(List<Item> items) {
        Set<com.idealo.item.domain.Item> internalItems = getInternalItems(items);
        return calculate(internalItems);
    }

    private Double calculate(Set<com.idealo.item.domain.Item> internalItems) {
        return internalItems
                .stream()
                .mapToDouble(this::calculateItemPrice)
                .sum();
    }


    private Double calculateItemPrice(com.idealo.item.domain.Item item) {
        Optional<Offer> optionalOffer = offerService.getOffer(item.getName());
        if (optionalOffer.isPresent()) {
            Offer offer = optionalOffer.get();
            if (offer.getPrice() != null) {
                Double offeredPriceTotal = (item.getQuantity() / offer.getQuantity()) * offer.getPrice();
                Double standardPriceTotal = (item.getQuantity() % offer.getQuantity()) * offer.getItemPrice();
                return offeredPriceTotal + standardPriceTotal;
            }
            return item.getQuantity() * offer.getItemPrice();
        }
        log.error("There is no product with name: " + item.getName());
        return (double) 0;
    }

    private Set<com.idealo.item.domain.Item> getInternalItems(List<Item> items) {
        return items.stream()
                .map(item -> com.idealo.item.domain.Item.builder()
                        .name(item.getName())
                        .quantity(countSimilarItemsQty(item.getName(), items))
                        .build())
                .collect(Collectors.toSet());
    }

    private static Integer countSimilarItemsQty(String itemName, List<com.idealo.rest.dto.Item> items) {
        return Integer.valueOf((int) items.stream().filter(name -> name.getName().equalsIgnoreCase(itemName)).count());
    }


}
