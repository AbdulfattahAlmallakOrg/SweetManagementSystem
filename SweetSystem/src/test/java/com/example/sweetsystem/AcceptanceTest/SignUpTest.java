package com.example.sweetsystem.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpTest {
    @When("the user miss any info")
    public void the_user_miss_any_info() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("the system will display erorr message")
    public void the_system_will_display_erorr_message() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("the user provide invalid email format")
    public void the_user_provide_invalid_email_format() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }






}
