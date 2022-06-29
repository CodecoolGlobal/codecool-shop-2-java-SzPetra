package com.codecool.shop.dao;

import com.codecool.shop.model.Cart;
import com.codecool.shop.model.LineItem;
import com.codecool.shop.model.Product;

import java.util.Set;

public interface CartDao {

    void add(Cart cart);
    void remove(Product product);
    void addProduct(Product product);

    Set<LineItem> getAll();
}
