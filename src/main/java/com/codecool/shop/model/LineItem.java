package com.codecool.shop.model;

public class LineItem {

    private final int productId;
    private final String productName;
    private int quantity;

    public LineItem(Product product){
        this.productId = product.getId();
        this.productName = product.getName();
        this.quantity = 1;
    }

}
