package com.test.hikari.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

/**
 * Created by kotu on 8/18/16.
 */
public class Hikari {

    private static  HikariDataSource hikariDataSource;

    public static void initHikariDs() {
        HikariConfig config = new HikariConfig();
        config.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        config.setUsername("root");
        config.setPassword("");
        config.addDataSourceProperty("serverName", "localhost");
        config.addDataSourceProperty("port", "3306");
        config.addDataSourceProperty("databaseName", "test");
        hikariDataSource = new HikariDataSource(config);

    }

    public static Connection getConnection(){
        Connection connection = null;

        try {
            connection = hikariDataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }




}
