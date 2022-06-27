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

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
