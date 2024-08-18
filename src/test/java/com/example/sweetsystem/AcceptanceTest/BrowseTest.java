package com.example.sweetsystem.AcceptanceTest;

import com.example.sweetsystem.clasess.RecipesList;
import com.example.sweetsystem.clasess.UsersList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;

@Tag("tag2")

public class BrowseTest {



    @Given("user in main page")
    public void user_in_main_page() {
        UsersList.fillData();
        UsersList.login();
    }
    @When("User want to browse resipe click in resipe btn {string}")
    public void user_want_to_browse_resipe_click_in_resipe_btn(String string) {
        System.out.println("clicked");
    }
    @Then("all posts will appear with there  info")
    public void all_posts_will_appear_with_there_info() {
       if(RecipesList.Recipes.size()!=0){
           Assertions.assertTrue(true);
       }
       else Assertions.fail("field to load all Resipes");
    }
}
