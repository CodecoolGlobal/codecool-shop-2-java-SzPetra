package com.codecool.shop.dao.jdbc;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class ProductCategoryDaoJdbc implements ProductCategoryDao {

    private DataSource dataSource;

    public ProductCategoryDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(ProductCategory category) {
        try(Connection connection = dataSource.getConnection()) {
            String query = "INSERT INTO categories ( name, description, department)" +
                    "VALUES (?, ?, ? )";
            PreparedStatement prepStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            prepStatement.setString(1, category.getName());
            prepStatement.setString(2, category.getDescription());
            prepStatement.setString(3, category.getDepartment());

            prepStatement.executeUpdate();

            ResultSet rs = prepStatement.getGeneratedKeys();
            rs.next();
            category.setId(rs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException("Could not add category to database");
        }
    }

    @Override
    public ProductCategory find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<ProductCategory> getAll() {
        return null;
    }
}
