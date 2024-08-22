package com.example.sweetsystem.AcceptanceTest;

import com.example.sweetsystem.clasess.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;

import java.util.List;

@Tag("tag2")
public class RequestOrderSteps {
    Supplier supplier;
    StoreOwner owner;
    StoreOwner supplierOwner;
    Product product;
    String errorMessage;

    @Given("I have a supplier with ID {int} and a product with name {string}")
    public void i_have_a_supplier_with_id_and_a_product_with_name(int suppId, String name) {
        supplier = new Supplier("supp", "email", "pass", "supplier", "location");
        product = new Product(name, "wow prod", 100, 10, suppId);
        owner = new StoreOwner("owner", "email", "Owner", "pass", List.of(""), "location");
    }

    @When("owner request an order of {int} units from supplier")
    public void owner_request_an_order_of_units_for_product_from_supplier(int units) {
        errorMessage = owner.requestOrder(product.getId(), supplier.getId(), units);
    }

    @Then("successful message shown")
    public void successful_message_shown() {
        Assert.assertEquals(StoreOwner.SUCCESSFUL_OPERATION, errorMessage);
    }

    @When("owner request an order of {int} units from a supplier {int}")
    public void owner_request_an_order_of_units_for_product_from_a_supplier(int units, int suppId) {
        errorMessage = owner.requestOrder(product.getId(), suppId, units);
    }

    @Then("the system should show not an instance message")
    public void the_system_should_show_not_an_instance_message() {
        Assert.assertEquals(StoreOwner.NOT_AN_INSTANCE_MESSAGE, errorMessage);
    }

    @Given("I have a owner with ID {int} and a product with name {string}")
    public void i_have_a_owner_with_id_and_a_product_with_id(int ownerId, String name) {
        supplierOwner = new StoreOwner("supp", "email", "pass", "supplier", List.of(""), "location");
        product = new Product(name, "wow prod", 100, 10, ownerId);
        owner = new StoreOwner("owner", "email", "Owner", "pass", List.of(""), "location");
    }

    @When("I request an order of {int} units from owner {int}")
    public void i_request_an_order_of_units_for_product_from_owner(int units, int ownerId) {
        errorMessage = owner.requestOrder(product.getId(), ownerId, units);
    }

    @Then("the system should show invalid quantity message")
    public void the_system_should_show_invalid_quantity_message() {
        Assert.assertEquals(StoreOwner.INVALID_QUANTITY_MESSAGE, errorMessage);
    }
}
