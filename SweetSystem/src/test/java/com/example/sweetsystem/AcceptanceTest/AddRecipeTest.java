package com.example.sweetsystem.AcceptanceTest;

import com.example.sweetsystem.clasess.RecipesList;
import com.example.sweetsystem.clasess.UsersList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;

@Tag("tag2")
public class AddRecipeTest {
    public boolean make;
    public int count;
    @Given("user in add recipe page")
    public void userInAddRecipePage() {
        UsersList.fillData();
        UsersList.login();
    }
    @When("user enter all field and click post {string} and {string} and {string} and {string} and {string}")
    public void user_enter_all_field_and_click_post_and_and_and_and(String string, String string2, String string3, String string4, String string5) {
        count=0;
        if(RecipesList.chekAllDataFill(string4,string2,string3,string)){
            count=RecipesList.Recipes.size();
            RecipesList.makeRecipe(string,string2,string3,string4,string5);
            make=true;
            Assertions.assertTrue(true);
        }
        else{
            make=false;
            Assertions.fail("you dont fill all fields");
        }
    }
    @Then("the post will create")
    public void thePostWillCreate() {
    if(make&&RecipesList.Recipes.size()==(count+1)){
        System.out.println("Recipe created:\n "+"Recipe Name : "+RecipesList.Recipes.get(RecipesList.Recipes.size()-1).getName()+"\n Recipe Image Path: "+RecipesList.Recipes.get(RecipesList.Recipes.size()-1).getImage()+"\n Recipe description: "+RecipesList.Recipes.get(RecipesList.Recipes.size()-1).getDescription());
        Assertions.assertTrue(true);
    }
    else Assertions.fail("the resipe not created");
    }


    @When("user enter all field  except one and click post {string} and {string} and {string} and {string} and {string}")
    public void user_enter_all_field_except_one_and_click_post_and_and_and_and(String string, String string2, String string3, String string4, String string5) {
        count=0;
        if(RecipesList.chekAllDataFill(string4,string2,string3,string)){
            count=RecipesList.Recipes.size();
            RecipesList.makeRecipe(string,string2,string3,string4,string5);
            make=true;
            Assertions.fail("the recipe created but there is a field not filled");
        }
        else{
            make=false;
            Assertions.assertTrue(true,"you dont fill all fields");
        }
    }
    @Then("the post will not create")
    public void the_post_will_not_create() {
        if(make&&RecipesList.Recipes.size()==(count+1)){
            System.out.println("Recipe created:\n "+"Recipe Name : "+RecipesList.Recipes.get(RecipesList.Recipes.size()-1).getName()+"\n Recipe Image Path: "+RecipesList.Recipes.get(RecipesList.Recipes.size()-1).getImage()+"\n Recipe description: "+RecipesList.Recipes.get(RecipesList.Recipes.size()-1).getDescription());
            Assertions.fail("the recipe should not created");
        }
        else  Assertions.assertTrue(true);
    }
}
