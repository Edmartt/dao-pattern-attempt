
package com.edmartt.repository.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mariadb implements IConnector {

    private Connection connection=null;
    private final String DRIVER = "org.mariadb.jdbc.Driver";
    private String USER = "";
    private String PASSWORD = "";
    private final String DB_URL = "";

    @Override
    public Connection getConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected to database");
        }catch (ClassNotFoundException exception){
            System.out.println(exception);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return connection;
    }

    @Override
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}