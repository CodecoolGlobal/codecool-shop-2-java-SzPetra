package com.codecool.shop.model;

public enum Currency {

    FORINT(0.0025),
    USD(0.96),
    EUR(1);

    double priceInEuro;

    Currency(double priceInEuro) {
        this.priceInEuro = priceInEuro;
    }

    public double getPriceInEuro() {
        return priceInEuro;
    }
}
