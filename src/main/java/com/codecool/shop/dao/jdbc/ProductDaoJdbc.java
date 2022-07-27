package com.codecool.shop.dao.jdbc;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Currency;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import jdk.jfr.Category;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoJdbc implements ProductDao {

    private DataSource dataSource;
    private ProductCategoryDao prodCatDao;
    private SupplierDao supDao;

    public ProductDaoJdbc(DataSource dataSource, ProductCategoryDao prodCatDao, SupplierDao supDao) {
        this.dataSource = dataSource;
        this.prodCatDao = prodCatDao;
        this.supDao = supDao;
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
        try(Connection con = dataSource.getConnection()) {
            String query = "SELECT * FROM products" +
                    "WHERE id = ?";
            PreparedStatement prepStatement = con.prepareStatement(query);
            prepStatement.setInt(1, id);

            ResultSet rs = prepStatement.executeQuery();
            if(!rs.next()){
                return null;
            }
            String name = rs.getString(4);
            BigDecimal price = rs.getBigDecimal(6);
            String currency = rs.getString(7);
            String description = rs.getString(5);
            int category_id = rs.getInt(3);
            int supplier_id = rs.getInt(2);
            int product_id = rs.getInt(1);

            ProductCategory category = prodCatDao.find(category_id);
            Supplier supplier = supDao.find(supplier_id);

            Product newProd =  new Product(name, price, Currency.EUR, description, category, supplier);
            newProd.setId(product_id);

            return newProd;
        } catch (SQLException e) {
            throw new RuntimeException("Could not find product with given ID");
        }
    }

    @Override
    public void remove(int id) {
        try(Connection con = dataSource.getConnection()) {
            String query = "DELETE FROM products" +
                    "WHERE ID = ?";
            PreparedStatement prepStatement = con.prepareStatement(query);
            prepStatement.setInt(1, id);

            prepStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Could not remove product from database");
        }
    }

    @Override
    public List<Product> getAll() {
        try(Connection con = dataSource.getConnection()) {
            String query = "SELECT * FROM products";

            PreparedStatement prepStatement = con.prepareStatement(query);
            ResultSet rs = prepStatement.executeQuery();
            if(!rs.next()) {
                return null;
            }
            List<Product> result = new ArrayList<>();
            while(!rs.next()) {
                int prodId = rs.getInt(1);
                result.add(this.find(prodId));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException("Could not get all products from database");
        }
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        try(Connection con = dataSource.getConnection()) {
            String query = "SELECT * FROM products" +
                    "WHERE supplier_ID = ?";

            PreparedStatement prepStatement = con.prepareStatement(query);
            prepStatement.setInt(1, supplier.getId());

            ResultSet rs = prepStatement.executeQuery();
            if(!rs.next()) {
                return null;
            }
            List<Product> result = new ArrayList<>();
            while(!rs.next()) {
                int prodId = rs.getInt(1);
                result.add(this.find(prodId));
            }
            return result;

        } catch (SQLException e) {
            throw new RuntimeException("Could not get product by supplier from database");
        }
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        try(Connection con = dataSource.getConnection()) {
            String query = "SELECT * FROM products" +
                    "WHERE category_ID = ?";

            PreparedStatement prepStatement = con.prepareStatement(query);
            prepStatement.setInt(1, productCategory.getId());

            ResultSet rs = prepStatement.executeQuery();
            if(!rs.next()) {
                return null;
            }
            List<Product> result = new ArrayList<>();
            while(!rs.next()) {
                int prodId = rs.getInt(1);
                result.add(this.find(prodId));
            }
            return result;

        } catch (SQLException e) {
            throw new RuntimeException("Could not get product by supplier from database");
        }
    }
}
