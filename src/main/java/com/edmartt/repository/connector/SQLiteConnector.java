package com.edmartt.repository.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnector implements IConnector {
    private Connection connection = null;

    @Override
    public Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        } catch (SQLException ex) {
            System.out.println(ex);

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return connection;
    }

    @Override
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}