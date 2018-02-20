package com.idealo.offer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Offer {

    @Id
    private String itemName;

    private Double itemPrice;

    private Integer quantity;

    private Double price;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offer)) return false;

        Offer offer = (Offer) o;

        if (!getItemName().equals(offer.getItemName())) return false;
        if (!(getItemPrice().equals(offer.getItemPrice()))) return false;
        if (getQuantity() != null ? !getQuantity().equals(offer.getQuantity()) : offer.getQuantity() != null)
            return false;
        return getPrice() != null ? (getPrice().equals(offer.getPrice())) : offer.getPrice() == null;
    }

    @Override
    public int hashCode() {
        int result = getItemName().hashCode();
        result = 31 * result + getItemPrice().hashCode();
        result = 31 * result + (getQuantity() != null ? getQuantity().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        return result;
    }
}
