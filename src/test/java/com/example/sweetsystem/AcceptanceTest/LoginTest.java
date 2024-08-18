package com.example.sweetsystem.AcceptanceTest;

import com.example.sweetsystem.clasess.LoginHelper;
import com.example.sweetsystem.clasess.UsersList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;

@Tag("tag2")
public class LoginTest {
   public LoginHelper login;
   public boolean state;
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        UsersList.fillData();
        login=new LoginHelper();
    }
    @When("the user enters a valid username {string} and a valid password {string}")
    public void the_user_enters_a_valid_username_and_a_valid_password(String string, String string2) {

       state=login.theUserCanGo(string,string2);

    }
    @When("clicks the login button")
    public void clicks_the_login_button() {
        if(state){
            Assertions.assertTrue(true);
        }
        else
            Assertions.fail("dvdvdv");
    }
    @When("clicks the login button2")
    public void clicks_the_login_button2() {
        if(state){
            Assertions.fail("the user enter an invalid username and he enter ??");
        }
        else{
            Assertions.assertTrue(login.getMessage().equals("account not register"));
        }
    }
    @When("the user enters an invalid username {string}")
    public void theUserEntersAnInvalidUsername(String string) {
        state=login.theUserCanGo(string,"string2");
    }
    @When("the user enters an invalid password {string}")
    public void theUserEntersAnInvalidPassword(String string) {
        state=login.theUserCanGo("osama","osa123");
    }
    @When("clicks the login button3")
    public void clicksTheLoginButton3() {
       if(state){
           Assertions.fail("the password wrong and he go???");
       }
       else {
           Assertions.assertEquals("wrong password",login.getMessage());
       }
    }
    @When("the user leaves the username field empty and enters a password \"password1\"or empty pass with valid username\"osama\"")
    public void theUserLeavesTheUsernameFieldEmptyAndEntersAPasswordPassword1OrEmptyPassWithValidUsernameOsama() {
        state=login.allFieldIsFill("","");
    }
    @When("clicks the login button4")
    public void clicksTheLoginButton4() {
        if(state){
            Assertions.fail("the pass or username are empty..!");
        }
        else {
            Assertions.assertFalse(state);
        }
    }
    @Then("the login attempt fails with an error message for missing username")
    public void theLoginAttemptFailsWithAnErrorMessageForMissingUsername() {
        System.out.println("Pass or userName not filled. . . !");
    }
    @Then("the login attempt fails with an error pass message")
    public void theLoginAttemptFailsWithAnErrorPassMessage() {
        if(!state){
            System.out.println("The user not enter . . .!");
        }
    }
    @Then("the login attempt fails with an error message")
    public void theLoginAttemptFailsWithAnErrorMessage() {
       if(state){
           Assertions.fail("the user enter an invalid username and he enter ??");
       }
       else{
           Assertions.assertTrue(login.getMessage().equals("account not register"));
       }
    }
    @Then("the user is successfully logged in")
    public void the_user_is_successfully_logged_in() {

        if(state){
            Assertions.assertTrue(true);
        }
        else
            Assertions.fail("dvdvdv");

    }

}
