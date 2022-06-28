package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);
    Supplier find(int id);
    void remove(int id);

    List<Supplier> getAll();
}