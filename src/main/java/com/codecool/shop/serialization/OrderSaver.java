package com.codecool.shop.serialization;

import com.codecool.shop.model.Order;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OrderSaver {


    public static void saveOrder(Order order) throws IOException {
        Gson gson = new Gson();
        String filePath = "src/main/java/com/codecool/shop/exportFiles/order" + order.getOrderDate();

        System.out.println(gson.toJson(order));
        //BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        //writer.write("gson.toJson(order)");

        gson.toJson(order, new FileWriter(filePath));
    }
}
