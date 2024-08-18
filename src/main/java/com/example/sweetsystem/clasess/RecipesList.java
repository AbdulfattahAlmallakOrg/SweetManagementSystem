package com.example.sweetsystem.clasess;

import java.util.ArrayList;

public class RecipesList {
   public static ArrayList<Recipe>Recipes=new ArrayList<Recipe>();

   public void makeRecipe(Client u){
      Recipe r=new Recipe("osama res","cake2.jpg","this is sweet resipe","Milk,Egg,Wheet,Water,Glue","Wheet,Egg,Glue");
      u.addRecipe(r);
      Recipes.add(r);
   }

   public static boolean chekAllDataFill(String needs,String image,String discription,String Name){
    return !needs.isEmpty() && !image.isEmpty()  && !discription.isEmpty() && !Name.isEmpty();
   }
   public static void makeRecipe(String text, String imagePath, String rDescriptionText, String rneedText, String rAllergText){
      Recipe r=new Recipe(text,imagePath,rDescriptionText,rneedText,rAllergText);
      Client c=(Client) UsersList.currentUser;
      c.addRecipe(r);
      RecipesList.Recipes.add(r);
   }
}
