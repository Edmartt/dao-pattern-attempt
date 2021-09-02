package com.edmartt.repository;

import com.edmartt.users.Users;

public interface IDao {
    
    public void add(Users user);

    public String get(String name);

    public void getAll();

}
