package com.codecool.shop.model;

import java.math.BigDecimal;

public enum Currency {

    HUF(new BigDecimal("0.0025")),
    USD(new BigDecimal("0.96")),
    EUR(new BigDecimal("1"));

    private final BigDecimal exchangeRate;

    Currency(BigDecimal priceInEuro) {
        this.exchangeRate = priceInEuro;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }
}

