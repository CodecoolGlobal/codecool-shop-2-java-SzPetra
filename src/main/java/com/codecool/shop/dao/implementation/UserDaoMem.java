package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoMem implements UserDao {

    private List<User> users = new ArrayList<>();

    @Override
    public void add(User user, String hashPassword) {
        users.add(user);
    }

    @Override
    public User find(String email) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public String getUserPasswordByEmail(String email) {
        return null;
    }
}

