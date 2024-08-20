package com.example.sweetsystem.clasess;

public class User {
    public static int count=0;
    private String userName;
    private int id;
    private String email;
    private String password;
    private String type;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String location;
    public User(String userName, String email, String password,String type,String location){
        this.email=email;
        this.userName=userName;
        this.password=password;
        this.type=type;
        this.location=location;
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

}
