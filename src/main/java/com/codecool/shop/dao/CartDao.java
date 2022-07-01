package com.codecool.shop.dao;

import com.codecool.shop.model.Cart;
import com.codecool.shop.model.LineItem;
import com.codecool.shop.model.Product;

import java.math.BigDecimal;
import java.util.Set;

public interface CartDao {

    void add(Cart cart);
    void decreaseByOne(Product product);
    void increaseByOne(Product product);

    Set<LineItem> getAll();

    BigDecimal getTotalPrice();
    LineItem getLineItem(Product product);

    String getDataJson();
}
