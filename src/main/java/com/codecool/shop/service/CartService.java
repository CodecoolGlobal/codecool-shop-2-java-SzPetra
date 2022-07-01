package com.codecool.shop.service;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.LineItem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.User;

import java.util.*;

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

    public List<Map<String, String>> getCartContent(){
        Set<LineItem> lineItems = cartDao.getAll();
        List<Map<String, String>> result = new ArrayList<>();
        for( LineItem item : lineItems){
            result.add(createItemDetails(item));
        }
        return result;
    }

    public String getTotalPriceOfCart(){
        return String.valueOf(cartDao.getTotalPrice());
    }

    public String getLintItemByIdAsJson(int id){
        Product productToGet = productDao.find(id);
        LineItem result = cartDao.getLineItem(productToGet);
        if(result == null){
            return null;
        }
        return result.toString();
    }

    public String getCartContentAsJson(){
        return cartDao.getDataJson();
    }

    public void clearCart(){
        cartDao.add( new Cart(new User()));
    }

    private Map<String, String> createItemDetails(LineItem item){
        Map<String, String> itemDetails = new HashMap<>();
        itemDetails.put("id", String.valueOf(item.getProductId()));
        itemDetails.put("productName", item.getProductName());
        itemDetails.put("unitPrice", item.getUnitPrice().toString());
        itemDetails.put("currency", item.getDefaultCurrency().toString());
        itemDetails.put("quantity", String.valueOf(item.getQuantity()));
        itemDetails.put("subtotalPrice", item.getTotalPrice().toString());
        return itemDetails;
    }

    public void changeLineItemQuantityBy(int id, int quantity){
        Product product = productDao.find(id);
        LineItem item = cartDao.getLineItem(product);
        item.setQuantity(item.getQuantity()+quantity);
    }


}
