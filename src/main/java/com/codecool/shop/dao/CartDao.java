package com.codecool.shop.dao;

import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.Supplier;
import java.util.List;

public interface CartDao {

    void add(Cart cart);
    void remove(int id);
    void addProductInCart(Product product);

    List<Product> getAll();
}
