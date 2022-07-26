package com.codecool.shop.model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.math.BigDecimal;
import java.util.Objects;

public class LineItem {
    private final int productId;
    private final String productName;
    private final BigDecimal unitPrice;
    private Currency defaultCurrency;
    private int quantity;

    public LineItem(Product product){
        this.productId = product.getId();
        this.productName = product.getName();
        this.unitPrice = product.getDefaultPrice();
        this.defaultCurrency = product.getDefaultCurrency();
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


    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public Currency getDefaultCurrency() {
        return defaultCurrency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return productId == lineItem.productId;
    }



    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(this);
        jsonElement.getAsJsonObject().addProperty("subTotal", getTotalPrice().intValue());
        return gson.toJson(jsonElement);
    }
}
