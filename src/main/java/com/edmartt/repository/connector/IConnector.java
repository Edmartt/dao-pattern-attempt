package com.edmartt.repository.connector;
import java.sql.Connection;

public interface IConnector {
    public Connection getConnection();
    public void closeConnection();
}