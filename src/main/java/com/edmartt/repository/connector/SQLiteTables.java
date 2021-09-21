package com.edmartt.repository.connector;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteTables {
    private SQLiteConnector sqliteconnector = null;

    public SQLiteTables(SQLiteConnector sqliteconnector){
        this.sqliteconnector = sqliteconnector;
    }
    private String sql = "CREATE TABLE IF NOT EXISTS `users`( \n"
    + "  `id` INTEGER PRIMARY KEY AUTOINCREMENT, \n"
    + "  `name` varchar(30),\n"
    + "  `lastname` varchar(50),\n"
    + "  `country` varchar(80),\n"
    + " `email` varchar(80))";

    public void createTable(){
        try (var connection = sqliteconnector.getConnection()) {
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
