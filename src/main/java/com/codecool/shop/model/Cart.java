package com.codecool.shop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cart {

    private User owner;
    private Set<LineItem> products;

    public Cart(User owner) {
        this.owner = owner;
        this.products = new HashSet<>();
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
