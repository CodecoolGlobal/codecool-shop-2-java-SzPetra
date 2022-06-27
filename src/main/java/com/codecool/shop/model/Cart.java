package com.codecool.shop.model;

import java.math.BigDecimal;
import java.util.Map;

public class Cart {

    private User owner;
    private Map<Product,Integer> products;

    public Cart(User owner, Map<Product, Integer> products) {
        this.owner = owner;
        this.products = products;
    }

    public void addProduct(Product product){

    }

    public void removeProduct(Product product){

    }

    public BigDecimal getFullPrice(){
        return new BigDecimal(1);
    }

    public void checkoutCart(){

    }

}
