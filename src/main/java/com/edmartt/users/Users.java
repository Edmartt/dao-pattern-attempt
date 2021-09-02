package com.edmartt.users;

public class Users {

    private String name;
    private String lastname;
    private String country;
    private String email;

    public Users(String name, String lastname, String country, String email){
        this.name = name;
        this.lastname = lastname;
        this.country = country;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}