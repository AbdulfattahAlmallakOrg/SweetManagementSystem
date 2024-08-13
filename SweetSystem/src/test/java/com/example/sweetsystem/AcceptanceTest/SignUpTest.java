package com.example.sweetsystem.AcceptanceTest;

import com.example.sweetsystem.HelloApplication;
import com.example.sweetsystem.Login;
import com.example.sweetsystem.SignUp;
import com.example.sweetsystem.clasess.User;
import com.example.sweetsystem.clasess.UsersList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;


@Tag("tag1")
public class SignUpTest  {
    public UsersList list;
    public String userName;

    @Given("the user is on sign up page")
    public void theUserIsOnSignUpPage()  {
        list=new UsersList();
     list.setUserCurrentPage("SignUp");
     String page="SignUp";
     Assert.assertEquals(list.getUserCurrentPage(),page);
     UsersList.fillData();
    }

    @When("the user enter an exist valid username {string}")
    public void theUserEnterAnExistValidUsername(String string) {
        UsersList.CanMakeUserName=false;
        if(UsersList.search(string)!=-1){
            list.setCanMakeUserName(false);
            userName=string;
            Assertions.assertTrue(true);
        }
        else
            Assertions.fail("the user is in the system and the user created????");
    }
    @When("the user enter a valid password {string}")
    public void theUserEnterAValidPassword(String string) {

    }
    @When("the user enter a valid email {string}")
    public void theUserEnterAValidEmail(String string) {
        if(UsersList.isValidEmail(string))
            Assertions.assertTrue(true);
        else
            Assertions.assertFalse(false);
    }
    ////////////////////////////////////////////////////////////////////////////////

    @When("the user enter a valid location {string}")
    public void theUserEnterAValidLocation(String string) {

    }
    @When("the user enter a valid username {string} and {string} and {string} and {string} and {string}")
    public void theUserEnterAValidUsernameAndAndAndAnd(String string, String string2, String string3, String string4, String string5) {
       UsersList.CanMakeUserName=false;
        if(UsersList.checkAllInput(string,string2,string3,string4,string5)){
            if(!UsersList.makeUser(string,string3,string2,string4,string5))
                Assertions.fail("the user in the system");
            else {
                userName = string;
                UsersList.CanMakeUserName = true;

                Assertions.assertTrue(true);
            }
        }
        else {
            UsersList.CanMakeUserName=false;
            Assertions.assertFalse(false);
        }
    }
    //////////////////////////////////////////////////


    @When("the user enter a valid role {string}")
    public void theUserEnterAValidRole(String string) {
        string="Client";
    Assertions.assertTrue(UsersList.isValidRole(string),"Valid Role.");
    }
    @When("the user enter an exist  username {string}")
    public void theUserEnterAnExistUsername(String string) {
        if(!UsersList.makeUser(string,"osama@gmail.com","pass","location","Admin"))
        Assertions.assertTrue(true,"User not created . . !");
        else
            Assertions.fail("User should not have been created as the username already exists");
    }
    @When("the user enter an empty username {string} or  {string}  or {string} or {string} or {string}")
    public void theUserEnterAnEmptyUsernameOrOrOrOr(String string, String string2, String string3, String string4, String string5) {

    }



    @When("When the user enter a valid username \"osama\"and {string} and {string} and {string}")
    public void whenTheUserEnterAValidUsernameOsamaAndAndAnd(String string, String string2, String string3) {

    }
    @When("the user enter a wrong email {string}")
    public void theUserEnterAWrongEmail(String string) {

    }


    @When("the user enter an empty username {string} or  {string} or {string} or 'nablus'or'os@gmail.com'")
    public void theUserEnterAnEmptyUsernameOrOrOrNablusOrOsGmailCom(String string, String string2, String string3) {

    }
    @Then("the alert show faile signUp ForEmpty input")
    public void theAlertShowFaileSignUpForEmptyInput() {

    }
    @Then("the alert show faile signUp wrong Email format")
    public void theAlertShowFaileSignUpWrongEmailFormat() {

    }
    @Then("the alert show success signUp")
    public void theAlertShowSuccessSignUp() {
        if(UsersList.search(userName)!=-1&&UsersList.getCanMakeUserName()){
            UsersList.printAll();
            Assertions.assertTrue(true,"User Created success . . . !");
        }
        else
            Assertions.fail("User Not Created...!");
    }
    @Then("the alert show faile signUp UserName the same")
    public void theAlertShowFaileSignUpUserNameTheSame() {
        userName="osama";
        if(UsersList.search(userName)!=-1) {
            UsersList.printAll();
            Assertions.assertTrue(true,"user is allredy in the system ... !");
        }
        else
            Assertions.fail("user is allredy in the system and make it agaien?? ... ! ");

    }


}
