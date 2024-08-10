package com.example.sweetsystem.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SignUpTest {
    @Given("the user is on sign up page")
    public void theUserIsOnSignUpPage() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("the user enter a valid username {string}")
    public void theUserEnterAValidUsername(String string) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("the user enter a valid password {string}")
    public void theUserEnterAValidPassword(String string) {
        System.out.println("Done");

    }

    @When("the user enter a valid email {string}")
    public void theUserEnterAValidEmail(String string) {
        System.out.println("Done");

    }

    @When("the user enter a valid location {string}")
    public void theUserEnterAValidLocation(String string) {
        System.out.println("Done");
    }

    @When("the user enter a valid role {string}")
    public void theUserEnterAValidRole(String string) {
        System.out.println("Done");
    }



}
