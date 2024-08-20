package com.example.sweetsystem.AcceptanceTest;

import static org.junit.Assert.*;

import com.example.sweetsystem.clasess.OwnerAndSupplier;
import com.example.sweetsystem.clasess.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;


public class AddProductTest {

    private OwnerAndSupplier owner;
    private String errorMessage;

    /*@Given("I have an empty inventory")
    public void i_have_an_empty_inventory() {
        owner = new OwnerAndSupplier("Owner Name", "owner@example.com", "password", "owner", "location");
        assertTrue(owner.getProducts().isEmpty());
    }

    @When("I add a new product with the name {string}, description {string}, price {double}, and quantity {int}")
    public void i_add_a_new_product(String name, String description, double price, int quantity) {
        try {
            owner.addNewProduct(name, description, price, quantity);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("the product {string} should be in the inventory")
    public void the_product_should_be_in_the_inventory(String name) {
        Product product = Product.getProduct(name);
        assertNotNull(product);
        assertTrue(owner.getProducts().contains(product));
    }

    @Then("the inventory should contain {int} product(s)")
    public void the_inventory_should_contain_products(int count) {
        assertEquals(count, owner.getProducts().size());
    }

    @Then("the product {string} should have a quantity of {int}")
    public void the_product_should_have_a_quantity_of(String name, int quantity) {
        Product product = Product.getProduct(name);
        assertNotNull(product);
        assertEquals(quantity, product.getQuantity());
    }

    @Then("the product should not be added to the inventory")
    public void the_product_should_not_be_added_to_the_inventory() {
        assertTrue(owner.getProducts().isEmpty());
    }

    @Then("an error message should pop up")
    public void an_error_message_should_pop_up() {
        assertNotNull(errorMessage);
    }

    @Given("I have an inventory with a product {string} with description {string}, price {double}, and quantity {int}")
    public void i_have_an_inventory_with_a_product(String name, String description, double price, int quantity) {
        owner = new OwnerAndSupplier("Owner Name", "owner@example.com", "password", "owner", "location");
        owner.addNewProduct(name, description, price, quantity);
    }

    @Then("the inventory should contain {int} product named {string}")
    public void the_inventory_should_contain_product_named(int count, String name) {
        assertEquals(count, owner.getProducts().size());
        Product product = Product.getProduct(name);
        assertNotNull(product);
    }

    @Then("the quantity should be increased by the new quantity")
    public void the_quantity_should_be_increased_by_the_new_quantity() {
        Product product = owner.getProducts().get(0);
        assertEquals(10, product.getQuantity()); // Assuming 5 was initially added, and 5 more in the scenario.
    }
    */

}

