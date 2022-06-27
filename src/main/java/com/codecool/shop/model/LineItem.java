package com.codecool.shop.model;

import java.math.BigDecimal;

public class LineItem {

    private final int productId;
    private final String productName;
    private final BigDecimal unitPrice;
    private int quantity;

    public LineItem(Product product){
        this.productId = product.getId();
        this.productName = product.getName();
        this.unitPrice = product.getDefaultPrice();
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

    public BigDecimal getTotalPrice(){
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    public boolean compareToProduct(Product product){
        return productId == product.getId();
    }
}
