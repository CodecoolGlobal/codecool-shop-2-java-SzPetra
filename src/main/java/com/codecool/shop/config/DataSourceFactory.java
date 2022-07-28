package com.codecool.shop.config;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public class DataSourceFactory {


    public static DataSource createDataSource(){
        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setDatabaseName(System.getenv("DB_NAME"));
        ds.setPassword(System.getenv("PASSWORD"));
        ds.setUser(System.getenv("PASSWORD"));
        return ds;
    }
}
