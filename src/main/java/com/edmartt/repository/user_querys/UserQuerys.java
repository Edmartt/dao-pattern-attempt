package com.edmartt.repository.user_querys;

import com.edmartt.users.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import com.edmartt.repository.IDao;
import com.edmartt.repository.connector.Mariadb;

public class UserQuerys implements IDao{
	private IConnector connector;
	
	public UserQuerys(IConnector connector)
	{
		this.connector = connector;
	}
	
    @Override
    public void add(Users user){
        String query = "INSERT INTO users (name, lastname, country, email) VALUES(?, ?, ?, ?)";
        try(var connection = connector.getConnection())
		{
            var preparedStm = connection.prepareStatement(query);
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
        }
    }

    @Override
    public String get(String name){
        String query="SELECT * FROM users WHERE name=?";
        try(var connection = connector.getConnection()) {
            var preparedStm = connection.prepareStatement(query);
            preparedStm.setString(1, name);
            var result = preparedStm.executeQuery();
            if(result.next()){
                return result.getString("name");
            }
        }
        catch (SQLException e) {   
            System.out.println(e);
        }
        return "The user doesn't exists";
    }

    @Override
    public void getAll() {
        System.out.println("hello world");
    }
}