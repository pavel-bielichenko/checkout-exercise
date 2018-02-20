package com.idealo.checkout;

import com.idealo.rest.dto.Item;

import java.util.List;

public interface CheckoutService {
    Double calculateTotal(List<Item> items);
}
