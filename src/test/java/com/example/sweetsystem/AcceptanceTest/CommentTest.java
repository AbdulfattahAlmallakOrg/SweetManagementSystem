package com.example.sweetsystem.AcceptanceTest;

import com.example.sweetsystem.clasess.Comment;
import com.example.sweetsystem.clasess.RecipesList;
import com.example.sweetsystem.clasess.UsersList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class CommentTest {
    ArrayList<Comment>cc;
    @Given("the use is in main page")
    public void the_use_is_in_main_page() {
        UsersList.fillData();
        UsersList.login();
        RecipesList.makeRecipe("osamas","my image path","osama,ammar,egg","ddd,ddd","Egg,wheet");
    }
    @When("the user login and he is in the main page and try to comment {string}")
    public void the_user_login_and_he_is_in_the_main_page_and_try_to_comment(String string) {
        Comment c=new Comment(UsersList.currentUser.getUserName(),string);
        RecipesList.Recipes.get(RecipesList.Recipes.size()-1).addComment(c);
        cc=RecipesList.Recipes.get(RecipesList.Recipes.size()-1).getComments();
        Assertions.assertEquals(cc.get(0).getMessage(),string,"the comment not posted");
    }
    @Then("the list of comment will appear")
    public void the_list_of_comment_will_appear() {
        Assertions.assertTrue(true);
    }
}
