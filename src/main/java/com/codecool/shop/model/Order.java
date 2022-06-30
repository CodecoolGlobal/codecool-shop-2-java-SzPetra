package com.codecool.shop.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Order {

    private List<Map<String, String>> orderDetails;
    private int totalPrice;
    private User user;
    private LocalDate orderDate;

    public Order(List<Map<String, String>> orderDetails, int totalPrice, User user, LocalDate orderDate) {
        this.orderDetails = orderDetails;
        this.totalPrice = totalPrice;
        this.user = user;
        this.orderDate = orderDate;
    }
}
