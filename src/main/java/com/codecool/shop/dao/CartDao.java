package com.codecool.shop.dao;

import com.codecool.shop.model.Cart;
import com.codecool.shop.model.LineItem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.Supplier;
import java.util.List;
import java.util.Set;

public interface CartDao {

    void add(Cart cart);
    void remove(int id);
    void addProductInCart(Product product);

    Set<LineItem> getAll();
}
