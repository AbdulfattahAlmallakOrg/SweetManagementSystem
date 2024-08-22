package com.example.sweetsystem.Controllers;

import com.example.sweetsystem.clasess.User;

public class AdminOwner extends User {
    private String type;
    private String password;
    private String ID;

    // Constructor
    public AdminOwner(String userName, String email, String password, String type, String location, String ID) {
        super(userName, email, password, type, location);
        this.password = password;
        this.type = type;
        this.ID = ID;
    }

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Name: " + this.getUserName() + ", Email: " + this.getEmail() + ", Type: " + this.getType();
    }
}
