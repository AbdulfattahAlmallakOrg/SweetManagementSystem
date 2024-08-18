package com.example.sweetsystem.clasess;

import java.util.ArrayList;

public class Client extends User {
    private ArrayList<Recipe>Recipes=new ArrayList<Recipe>();
    public Client(String userName, String email, String password,String type,String location) {
        super(userName, email, password,type,location);
    }


    public ArrayList<Recipe> getRecipes() {
        return Recipes;
    }


    public void addRecipe(Recipe r){
        Recipes.add(r);
    }
}
