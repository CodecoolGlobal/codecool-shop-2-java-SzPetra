package com.codecool.shop.dao.jdbc;

import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Supplier;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoJdbc implements SupplierDao {

    DataSource dataSource;

    public SupplierDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Supplier supplier) {
        try(Connection con = dataSource.getConnection()) {
            String query = "INSERT INTO suppliers(name, description)" +
                    "VALUES(?, ?)";
            PreparedStatement prepStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            prepStatement.setString(1, supplier.getName());
            prepStatement.setString(2, supplier.getDescription());

            prepStatement.executeUpdate();

            ResultSet rs = prepStatement.getGeneratedKeys();
            rs.next();
            supplier.setId(rs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException("Could not add supplier to database");
        }
    }

    @Override
    public Supplier find(int id) {
        try(Connection con = dataSource.getConnection()) {
            String query = "SELECT * FROM suppliers " +
                    "WHERE id = ?";
            PreparedStatement prepStatement = con.prepareStatement(query);
            prepStatement.setInt(1, id);

            ResultSet rs = prepStatement.executeQuery();
            if(!rs.next()) {
                return null;
            }
            String name = rs.getString(2);
            String description = rs.getString(3);

            Supplier newSup = new Supplier(name, description);
            newSup.setId(id);

            return newSup;
        } catch (SQLException e) {
            throw new RuntimeException("Could not find supplier in database");
        }
    }

    @Override
    public void remove(int id) {
        try(Connection con = dataSource.getConnection()) {
            String query = "DELETE FROM suppliers " +
                    "WHERE id = ?";
            PreparedStatement prepStatement = con.prepareStatement(query);
            prepStatement.setInt(1, id);

            prepStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Could not remove supplier from database");
        }
    }

    @Override
    public List<Supplier> getAll() {
        try(Connection con = dataSource.getConnection()) {
            String query = "SELECT * FROM suppliers";

            PreparedStatement prepStatement = con.prepareStatement(query);
            ResultSet rs = prepStatement.executeQuery();
            if(!rs.next()) {
                return null;
            }
            List<Supplier> result = new ArrayList<>();
            while (!rs.next()) {
                int supId = rs.getInt(1);
                result.add(this.find(supId));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException("Could not get all suppliers from database");
        }
    }
}
