package com.idealo.impl;

import com.idealo.checkout.CheckoutService;
import com.idealo.rest.CheckoutResource;
import com.idealo.rest.dto.CheckoutRs;
import com.idealo.rest.dto.Item;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class CheckoutResourceImpl implements CheckoutResource {

    private final CheckoutService checkoutService;

    @Override
    public CheckoutRs checkout(List<Item> items) {
        return CheckoutRs.builder()
                .totalAmount(checkoutService.calculateTotal(items))
                .build();
    }
}
