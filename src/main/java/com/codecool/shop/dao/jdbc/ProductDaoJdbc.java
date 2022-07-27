package com.codecool.shop.dao.jdbc;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class ProductDaoJdbc implements ProductDao {

    private DataSource dataSource;

    public ProductDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Product product) {
        try(Connection connection = dataSource.getConnection()) {
            String query = "INSERT INTO products (supplier_ID, category_ID, name, description, price, currency)" +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement prepStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            prepStatement.setInt(1, product.getSupplier().getId());
            prepStatement.setInt(2, product.getProductCategory().getId());
            prepStatement.setString(3, product.getName());
            prepStatement.setString(4, product.getDescription());
            prepStatement.setBigDecimal(5, product.getPrice());
            prepStatement.setString(6, product.getDefaultCurrency().getStringRepresentation());

            prepStatement.executeUpdate();

            ResultSet rs = prepStatement.getGeneratedKeys();
            rs.next();
            product.setId(rs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException("Could not add product to database");
        }

    }

    @Override
    public Product find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        return null;
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return null;
    }

    @Override
    public Product getBy(Product product) {
        return null;
    }
}
