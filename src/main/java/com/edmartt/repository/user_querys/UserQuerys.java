package com.edmartt.repository.user_querys;

import com.edmartt.users.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import com.edmartt.repository.IDao;
import com.edmartt.repository.connector.Mariadb;

public class UserQuerys implements IDao{

    private PreparedStatement preparedStm = null;
    private Connection connection = null;
    private ResultSet result = null;
    private Mariadb db_connector = null;

    @Override
    public void add(Users user){
        db_connector = new Mariadb();
        String query = "INSERT INTO users (name, lastname, country, email) VALUES(?, ?, ?, ?)";
        connection = db_connector.getConnection()  ;

        try {
            preparedStm = connection.prepareStatement(query);
            preparedStm.setString(1, user.getName());
            preparedStm.setString(2, user.getLastname());
            preparedStm.setString(3, user.getCountry());
            preparedStm.setString(4, user.getEmail());
            int result = preparedStm.executeUpdate();

            if (result > 0){
                System.out.println("User added");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally{
            db_connector.closeConnection();
        }
    }

    @Override
    public String get(String name){
        db_connector = new Mariadb();
        String query="SELECT * FROM users WHERE name=?";
        connection = db_connector.getConnection();
        
        try {
            preparedStm = connection.prepareStatement(query);
            preparedStm.setString(1, name);
            this.result = preparedStm.executeQuery();
            if(this.result.next()){
                return result.getString("name");
            }
        }
        catch (SQLException e) {   
            System.out.println(e);
        }
        finally{
            db_connector.closeConnection();
        }
        return "The user doesn't exists";
    }

    @Override
    public void getAll() {
        System.out.println("hello world");
    }
}