package com.codecool.shop.service;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;

public class CartService {

    private CartDao cartDao;
    private ProductDao productDao;

    public CartService(CartDao cartDao, ProductDao productDao) {
        this.cartDao = cartDao;
        this.productDao = productDao;
    }

    public void addProductToCart(int id){
        Product productToAdd = productDao.find(id);
        cartDao.addProduct(productToAdd);
    }

    public void removeProductFromCart(int id){
        Product productToRemove = productDao.find(id);
        cartDao.remove(productToRemove);
    }


}
