package com.edmartt;

import com.edmartt.repository.IDao;
import com.edmartt.repository.user_querys.UserQuerys;
import com.edmartt.users.Users;

public class Main {

    public static void main(String... args){
        Users user = new Users("Test", "Data", "Git", "mail@mail.com");
        IDao querys = new UserQuerys();
        querys.add(user);
    }
}
