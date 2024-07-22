package com.example.sweetsystem;

import java.util.ArrayList;

public class User {
    private String userName;
    private String email;
    private String password;

    User(String userName,String email ,String password){
        this.email=email;
        this.userName=userName;
        this.password=password;
    }
//getters


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
//setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
