package com.example.sweetsystem;

import java.util.ArrayList;

public class UsersList {
    public static ArrayList<User>users=new ArrayList<User>();
    public static User currentUser;


    public static int search(String username){
        for (int i=0;i<users.size();i++) {
        if(username.equals(users.get(i).getUserName()))return i;
        }
        return -1;
    }
    public static void printAll(){
        System.out.println("***********************************************************");
        for(User user:users){
            System.out.println(user.getUserName()+" "+user.getEmail()+" "+user.getPassword());
        }
        System.out.println("***********************************************************");
    }
}
