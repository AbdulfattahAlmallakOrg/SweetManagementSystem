package com.example.sweetsystem.AcceptanceTest;

import com.example.sweetsystem.clasess.Recipe;
import com.example.sweetsystem.clasess.RecipesList;
import com.example.sweetsystem.clasess.UsersList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class Filter {
public boolean find=false;

    @Given("the user in main page after login")
    public void the_user_in_main_page_after_login() {
        UsersList.fillData();
        UsersList.login();
        RecipesList.makeRecipe("blueBarry","path","decs","Egg","Wheet,Egg,Water");
        RecipesList.makeRecipe("redBarry","path","decs","Egg","Wheet,Egg,Water");

    }
    @When("click on filter and search by name {string}")
    public void click_on_filter_and_search_by_name(String string) {
       for (int i=0;i<RecipesList.Recipes.size();i++){
           if (string.equals(RecipesList.Recipes.get(i).getName())){
               find=true;
           }
       }
        Assertions.assertTrue(find);
    }
    private ArrayList<Recipe> searchByAllergy(ArrayList<Recipe> recipe,String xx) {
        ArrayList<Recipe> answer=new ArrayList<Recipe>();

        String allergy=xx;
        for(int i=0;i<recipe.size();i++){
            if(recipe.get(i).findAllerge(allergy.toLowerCase())){
                System.out.println("herew");
                answer.add(recipe.get(i));
            }
        }
        return answer;
    }
    @When("click on filter and search by Allegy {string}")
    public void click_on_filter_and_search_by_allegy(String string) {
        RecipesList.makeRecipe("redBarry","path","decs","Egg","Wheet,Egg,Water");
        ArrayList<Recipe> r=searchByAllergy(RecipesList.Recipes,string);
        if(r.size()==0){
            System.out.println(string);
            Assertions.fail("heree");
        }
        else {
            Assertions.assertTrue(true);
        }

    }
    @Then("the list of recipe")
    public void the_list_of_recipe() {
    Assertions.assertTrue(true);
    }
}
