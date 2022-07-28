package com.codecool.shop.service;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.User;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean registerNewUser(User newUser, String hashedPassword) {
        try {
            userDao.add(newUser, hashedPassword);
            return true;
        }catch( RuntimeException e){
            return false;
        }
    }
}
