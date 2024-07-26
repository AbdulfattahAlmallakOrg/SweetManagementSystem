package com.example.sweetsystem.clasess;

import java.util.ArrayList;

public class Client extends User {
    private ArrayList<Recipe>Recipes=new ArrayList<Recipe>();
    public Client(String userName, String email, String password,String type) {
        super(userName, email, password,type);
    }


    public ArrayList<Recipe> getRecipes() {
        return Recipes;
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        Recipes = recipes;
    }
    public void addRecipe(Recipe r){
        Recipes.add(r);
        System.out.println( Recipes.get(0).getImage());
    }
}
