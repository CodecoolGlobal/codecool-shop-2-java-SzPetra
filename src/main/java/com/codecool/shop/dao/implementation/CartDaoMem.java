package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.Supplier;

import java.util.ArrayList;
import java.util.List;

public class CartDaoMem implements CartDao  {

    private static CartDaoMem instance = null;
    private List<Product> productsInCart = new ArrayList<>();
    private Cart data;

    public static CartDaoMem getInstance() {
        if (instance == null) {
            instance = new CartDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Cart cart) {
        data = cart;
    }


    @Override
    public void remove(int id) {
    }

    @Override
    public void addProductInCart(Product product) {
        // filter if there is already one there
        productsInCart.add(product);
    }


    @Override
    public List<Product> getAll() {
        return productsInCart;
    }
}
