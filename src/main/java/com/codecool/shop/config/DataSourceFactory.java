package com.codecool.shop.config;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DataSourceFactory {


    public static DataSource createDataSource(){
        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setDatabaseName(System.getenv("DB_NAME"));
        ds.setPassword(System.getenv("PASSWORD"));
        ds.setUser(System.getenv("USER"));
        System.out.println("trying to connect..");
        try {
            ds.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("connection OK");
        return ds;
    }
}
