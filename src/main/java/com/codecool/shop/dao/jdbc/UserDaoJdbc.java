package com.codecool.shop.dao.jdbc;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.User;

import javax.sql.DataSource;
import java.sql.*;

public class UserDaoJdbc implements UserDao {

    private DataSource dataSource;

    public UserDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(User user, String hashPassword) {
        try(Connection connection = dataSource.getConnection()) {
            String query = "INSERT INTO users (first_name, last_name, email, password)" +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement prepStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            prepStatement.setString(1, user.getFirstName());
            prepStatement.setString(2, user.getLastName());
            prepStatement.setString(3, user.getEmail());
            prepStatement.setString(4, hashPassword);
            prepStatement.executeUpdate();
            ResultSet rs = prepStatement.getGeneratedKeys();
            rs.next();
            user.setId(rs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException("Could not add product to database");
        }
    }

    @Override
    public User find(String email) {
        return null;
    }

    @Override
    public void remove(int id) {

    }
}
