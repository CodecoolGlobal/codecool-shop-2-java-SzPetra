package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.*;

import java.math.BigDecimal;
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
    public void decreaseByOne(Product product) {
        data.removeProduct(product);
    }

    @Override
    public void increaseByOne(Product product) {
        data.addProduct(product);
    }


    @Override
    public Set<LineItem> getAll() {
        return data.getAllProducts();
    }

    @Override
    public BigDecimal getTotalPrice() {
        return data.getFullPrice();
    }

    @Override
    public LineItem getLineItem(Product product) {
        return data.getLineItem(product);
    }

    @Override
    public String getDataJson() {
        return data.convertProductsToJson();
    }
}
