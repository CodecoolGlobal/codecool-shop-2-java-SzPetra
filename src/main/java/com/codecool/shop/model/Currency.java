package com.codecool.shop.model;

import java.math.BigDecimal;

public enum Currency {

    FORINT(new BigDecimal("0.0025")),
    USD(new BigDecimal("0.96")),
    EUR(new BigDecimal("1"));

    private final BigDecimal priceInEuro;

    Currency(BigDecimal priceInEuro) {
        this.priceInEuro = priceInEuro;
    }

    public BigDecimal getPriceInEuro() {
        return priceInEuro;
    }
}
