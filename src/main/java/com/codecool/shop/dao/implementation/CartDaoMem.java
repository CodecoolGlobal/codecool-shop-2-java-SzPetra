package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CartDaoMem implements CartDao  {

    private static CartDaoMem instance = null;
    private static Cart data;

    public static CartDaoMem getInstance() {
        if (instance == null) {
            instance = new CartDaoMem();
        }
        if (data == null) {
            data = new Cart(new User());
        }
        return instance;

    }

    @Override
    public void add(Cart cart) {
        data = cart;
    }


    @Override
    public void remove(Product product) {
    }

    @Override
    public void addProduct(Product product) {
        data.addProduct(product);
    }


    @Override
    public Set<LineItem> getAll() {
        return data.getAllProducts();
    }

    @Override
    public String getTotalPrice() {
        return String.valueOf(data.getFullPrice());
    }
}
