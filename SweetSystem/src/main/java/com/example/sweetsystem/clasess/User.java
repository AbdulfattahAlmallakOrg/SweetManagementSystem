package com.example.sweetsystem.clasess;

import java.util.ArrayList;

public class User {
    public static int count=0;
    private String userName;
    private int id;
    private String email;
    private String password;
    private String type;

    public User(String userName, String email, String password,String type){
        this.email=email;
        this.userName=userName;
        this.password=password;
        this.type=type;
        count++;
        this.id=count;


    }


//getters

    public String getType(){
        return type;
    }
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

    public void setType(String type) {
        this.type = type;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
