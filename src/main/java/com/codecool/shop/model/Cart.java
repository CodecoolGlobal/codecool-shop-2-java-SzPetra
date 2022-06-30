package com.codecool.shop.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Cart {

    private User owner;
    private Set<LineItem> products;

    public Cart(User owner) {
        this.owner = owner;
        this.products = new HashSet<>();
    }

    public void addProduct(Product product){
        LineItem newLineItem = new LineItem(product);
        for(LineItem item: products){
            if(item.equals(newLineItem)){
                item.setQuantity(item.getQuantity()+1);
                return;
            }
        }
        products.add(newLineItem);
    }

    public void removeProduct(Product product){
        LineItem itemToRemove = new LineItem(product);
        for(LineItem item : products){
            if(item.equals(itemToRemove)){
                item.setQuantity(item.getQuantity()-1);
                if(item.getQuantity() <= 0){
                    products.remove(itemToRemove);
                }
                return;
            }
        }
    }

    public BigDecimal getFullPrice(){
        BigDecimal result = new BigDecimal(0);
        for(LineItem item: products){
            BigDecimal priceInOriginalCurrency = item.getTotalPrice();
            BigDecimal priceInEuro = priceInOriginalCurrency.multiply(item.getDefaultCurrency().getExchangeRate());
            result = result.add(priceInEuro);
        }
        return result;
    }

    public Set<LineItem> getAllProducts() {
        return products;
    }

    public void checkoutCart(){

    }

    public String convertProductsToJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(products);
    }
}
