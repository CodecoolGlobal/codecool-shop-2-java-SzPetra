package com.codecool.shop.model;

import java.math.BigDecimal;

public enum Currency {

    HUF(new BigDecimal("0.0025"), "HUF"),
    USD(new BigDecimal("0.96"), "USD"),
    EUR(new BigDecimal("1"), "EUR");

    private final BigDecimal exchangeRate;

    private final String stringRepresentation;

    Currency(BigDecimal priceInEuro, String stringRepresentation) {
        this.exchangeRate = priceInEuro;
        this.stringRepresentation = stringRepresentation;
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }
}

