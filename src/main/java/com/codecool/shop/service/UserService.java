package com.codecool.shop.service;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.User;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean registerNewUser(User newUser, String password) {
        try {
            userDao.add(newUser, password);
            return true;
        }catch( RuntimeException e){
            return false;
        }
    }

    public boolean checkPassword(String userEmail, String password){
        return false;
    }
}
