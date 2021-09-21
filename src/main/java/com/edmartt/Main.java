package com.edmartt;

import com.edmartt.repository.IDao;
import com.edmartt.repository.user_querys.UserQuerys;
import com.edmartt.users.Users;
import com.edmartt.repository.connector.Mariadb;
import com.edmartt.repository.connector.SQLiteConnector;
import com.edmartt.repository.connector.SQLiteTables;

public class Main {

    public static void main(String... args){
        Users user = new Users("Test", "Data", "Git", "mail@mail.com");
        new SQLiteTables(new SQLiteConnector()).createTable(); // Crea tablas en sqlite
        IDao querys = new UserQuerys(new SQLiteConnector());
        querys.add(user);
    }
}
