package com.codecool.shop.dao.jdbc;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.User;

import javax.sql.DataSource;

public class UserDaoJdbc implements UserDao {

    private DataSource dataSource;

    public UserDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(User user, String hashPassword) {

    }

    @Override
    public User find(String email) {
        return null;
    }

    @Override
    public void remove(int id) {

    }
}
