package com.example.sweetsystem.AcceptanceTest;

import com.example.sweetsystem.clasess.Client;
import com.example.sweetsystem.clasess.ManageAccounrHelper;
import com.example.sweetsystem.clasess.Recipe;
import com.example.sweetsystem.clasess.UsersList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;

import java.util.ArrayList;

@Tag("tag2")
public class ManageAccountTest {
    public boolean state;
    @Given("the user in profile page")
    public void the_user_in_profile_page() {
        UsersList.fillData();
        UsersList.login();
        Client u=(Client) UsersList.currentUser;
        ArrayList<Recipe>r=u.getRecipes();
    }
    @When("the user click on editBtn amd all field empty")
    public void the_user_click_on_edit_btn_amd_all_field_empty() {
    state= ManageAccounrHelper.checkAllEmpty("","","");
    if(state){
        Assertions.assertTrue(true);
    }
    else
        Assertions.fail("u let all feild empty . !");
    }
    @Then("the alert appear that the field are Empty")
    public void the_alert_appear_that_the_field_are_empty() {
        System.out.println("nothing to change");
    }
    @When("the user click on editBtn and the UserName only fill with new userName {string}")
    public void the_user_click_on_edit_btn_and_the_user_name_only_fill_with_new_user_name(String string) {
        if(ManageAccounrHelper.changeUserName(string)&&!ManageAccounrHelper.isTheSameUserName(string)&&ManageAccounrHelper.ChangeAllCheck("hello","hi","pay@gmail.com")){
            System.out.println(UsersList.currentUser.getLocation());
            UsersList.currentUser.setUserName(string);
            Assertions.assertTrue(true);
        }
        else Assertions.fail("the user cant change his user name to the name he put it ");
    }
    @Then("the alert appear that the User Name change success")
    public void the_alert_appear_that_the_user_name_change_success() {
        System.out.println("the user successufly change user name");

    }
    @When("the user click on editBtn and the password only fill with new userName {string}")
    public void the_user_click_on_edit_btn_and_the_password_only_fill_with_new_user_name(String string) {
        UsersList.currentUser.setLocation("aloo");
        if(ManageAccounrHelper.changePassword(string)&&!ManageAccounrHelper.isTheSamePassword(string)){
            UsersList.currentUser.setPassword(string);
            Assertions.assertTrue(true);
        }
        else Assertions.fail("the user cant change his password to the pass he put it ");
    }
    @Then("the alert appear that the Password change success")
    public void the_alert_appear_that_the_password_change_success() {
        System.out.println("the user successufly change password");
    }
    @When("the user click on editBtn and the UserName only fill with new Email {string}")
    public void the_user_click_on_edit_btn_and_the_user_name_only_fill_with_new_email(String string) {
        if(ManageAccounrHelper.changeEmail(string)&&!ManageAccounrHelper.isTheSameEmail(string)){
            UsersList.currentUser.setEmail(string);
            Assertions.assertTrue(true);
        }
        else Assertions.fail("the user cant change his Email to the Email he put it ");
    }
    @Then("the alert appear that the Email change success")
    public void the_alert_appear_that_the_email_change_success() {
        System.out.println("the user successufly change Email");
    }
}
