package com.codecool.shop.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Order {

    private List<Map<String, String>> orderDetails;
    private String totalPrice;
    private User user;
    private String orderDate;

    public Order(List<Map<String, String>> orderDetails, String totalPrice, User user, LocalDate orderDate) {
        this.orderDetails = orderDetails;
        this.totalPrice = totalPrice;
        this.user = user;
        this.orderDate = orderDate.toString();
    }

    public String getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderDetails=" + orderDetails +
                ", totalPrice=" + totalPrice +
                ", user=" + user +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }
}
