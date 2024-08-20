package com.example.sweetsystem.AcceptanceTest;//package com.example.sweetsystem.AcceptanceTest;
//
//import static com.example.sweetsystem.clasess.OwnerAndSupplier.INVALID_NAME_MESSAGE;
//import static com.example.sweetsystem.clasess.OwnerAndSupplier.INVALID_PERMISSION_MESSAGE;
//import static org.junit.Assert.*;
//
//import com.example.sweetsystem.clasess.OwnerAndSupplier;
//import com.example.sweetsystem.clasess.Product;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import io.cucumber.java.en.Then;
//
//public class DeleteProductTest {
//
//    private OwnerAndSupplier owner;
//    private OwnerAndSupplier anotherOwner;
//    private String errorMessage;
//
//    @Given("a product with name {string} exists and belongs to the user")
//    public void a_product_with_name_exists_and_belongs_to_the_user(String productName) {
//        owner = new OwnerAndSupplier("Owner Name", "owner@example.com", "password", "owner", "location");
//        owner.addNewProduct(productName, "Description", 10.0, 5);
//        assertNotNull(Product.getProduct(productName));
//        assertTrue(owner.getProducts().contains(Product.getProduct(productName)));
//    }
//
//    @When("the user deletes the product with name {string}")
//    public void the_user_deletes_the_product_with_name(String productName) {
//        owner.deleteProduct(productName);
//    }
//
//    @Then("the product should be removed from the user's catalog")
//    public void the_product_should_be_removed_from_the_user_s_catalog() {
//        assertNull(Product.getProduct("Product1"));
//        assertFalse(owner.getProducts().contains(Product.getProduct("Product1")));
//    }
//
//    @Given("a product with name {string} does not exist")
//    public void a_product_with_name_does_not_exist(String productName) {
//        owner = new OwnerAndSupplier("Owner Name", "owner@example.com", "password", "owner", "location");
//        assertNull(Product.getProduct(productName));
//    }
//
//    @When("the user tries to delete the product with name {string}")
//    public void the_user_tries_to_delete_the_product_with_name(String productName) {
//        owner.deleteProduct(productName);
//        errorMessage = INVALID_NAME_MESSAGE;
//    }
//
//    @Then("an invalid name message should be shown")
//    public void an_invalid_name_message_should_be_shown() {
//        assertEquals("ID is invalid", errorMessage);
//    }
//
//    @Given("a product with name {string} exists but does not belong to the user")
//    public void a_product_with_name_exists_but_does_not_belong_to_the_user(String productName) {
//        owner = new OwnerAndSupplier("Owner Name", "owner@example.com", "password", "owner", "location");
//        anotherOwner = new OwnerAndSupplier("Another Owner", "another@example.com", "password", "owner", "location");
//        anotherOwner.addNewProduct(productName, "Description", 10.0, 5);
//        assertTrue(anotherOwner.getProducts().contains(Product.getProduct(productName)));
//        assertFalse(owner.getProducts().contains(Product.getProduct(productName)));
//    }
//
//    @When("the user tries to delete the product with name {string}")
//    public void the_user_tries_to_delete_the_product_with_name_that_does_not_belong_to_them(String productName) {
//        owner.deleteProduct(productName);
//        errorMessage = INVALID_PERMISSION_MESSAGE;
//    }
//
//    @Then("an invalid permission message should be shown")
//    public void an_invalid_name_message_should_be_show() {
//        assertEquals("ID is invalid", errorMessage);
//    }
//}
//

import com.example.sweetsystem.clasess.OwnerAndSupplier;
import com.example.sweetsystem.clasess.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DeleteProductTest {
    private OwnerAndSupplier owner;
    private String deleteResult;
    private final String INVALID_NAME_MESSAGE = "ID is invalid";
    private final String INVALID_PERMISSION_MESSAGE = "Invalid permission";

    @Given("a product with name {string} exists and belongs to the user")
    public void a_product_with_name_exists_and_belongs_to_the_user(String productName) {
        owner = new OwnerAndSupplier("Owner", "owner@example.com", "password", "Owner", "Location");
        owner.addNewProduct(productName, "Description", 10.0, 5);
    }

    @Given("a product with name {string} does not exist")
    public void a_product_with_name_does_not_exist(String productName) {
        owner = new OwnerAndSupplier("Owner", "owner@example.com", "password", "Owner", "Location");
        // Ensure the product does not exist by not adding it to the catalog
    }

    @Given("a product with name {string} exists but does not belong to the user")
    public void a_product_with_name_exists_but_does_not_belong_to_the_user(String productName) {
        OwnerAndSupplier otherOwner = new OwnerAndSupplier("OtherOwner", "other@example.com", "password", "Owner", "Location");
        otherOwner.addNewProduct(productName, "Description", 10.0, 5);
        owner = new OwnerAndSupplier("Owner", "owner@example.com", "password", "Owner", "Location");
    }

    @When("the user deletes the product with name {string}")
    public void the_user_deletes_the_product_with_name(String productName) {
        try {
            owner.deleteProduct(productName);
            deleteResult = null;
        } catch (Exception e) {
            deleteResult = e.getMessage();
        }
    }

    @Then("the product should be removed from the user's catalog")
    public void the_product_should_be_removed_from_the_user_s_catalog() {
        Product product = Product.getProduct("Product1");
        Assert.assertNull(product);
    }

    @Then("an invalid name message should be shown")
    public void an_invalid_name_message_should_be_shown() {
        Assert.assertEquals(INVALID_NAME_MESSAGE, deleteResult);
    }

    @Then("an invalid permission message should be shown")
    public void an_invalid_permission_message_should_be_shown() {
        Assert.assertEquals(INVALID_PERMISSION_MESSAGE, deleteResult);
    }
}
