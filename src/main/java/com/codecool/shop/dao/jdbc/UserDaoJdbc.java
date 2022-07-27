package com.codecool.shop.dao.jdbc;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.ProductCategory;
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
            throw new RuntimeException("Could not add user to database");
        }
    }

    @Override
    public User find(String email){
        try(Connection con = dataSource.getConnection()) {
            String query = "SELECT * FROM users " +
                    "WHERE email = ?";
            PreparedStatement prepStatement = con.prepareStatement(query);
            prepStatement.setString(1, email);

            ResultSet rs = prepStatement.executeQuery();
            if(!rs.next()){
                return null;
            }
            int user_id = rs.getInt(1);
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);
            User result = new User(firstName, lastName, email);
            result.setId(user_id);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException("Could not find user with given email");
        }
}

    @Override
    public void remove(int id) {

    }
}
