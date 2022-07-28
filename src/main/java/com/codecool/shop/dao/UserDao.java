package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.User;

import java.util.List;

public interface UserDao {

    void add(User user, String hashPassword);
    User find(String email);
    void remove(int id);
    String getUserPasswordByEmail(String email);

}
