package com.example.sweetsystem.AcceptanceTest;

import com.example.sweetsystem.clasess.Product;
import com.example.sweetsystem.clasess.RecipesList;
import com.example.sweetsystem.clasess.UsersList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;

@Tag("tag2")

public class BrowseTest {
public Product x;


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
           String x2=RecipesList.Recipes.get(0).getAllergy().toString();

           System.out.println("the recipe is : "+x2 );

           Assertions.assertTrue(true);
       }
       else Assertions.fail("field to load all Resipes");
    }
    @When("User want to browse product click in product btn {string}")
    public void user_want_to_browse_product_click_in_product_btn(String string) {

        Product.makeTestProduct();
        Product a=Product.products.get(0);
        x=a;
        if(a.getName().equals("product1"))
        Assertions.assertTrue(true);
        else
            Assertions.fail("the product dose not appear");
    }
    @Then("all Products will appear with there  info")
    public void all_products_will_appear_with_there_info() {
        String answer=x.getName()+" "+x.getDescription()+" "+x.getId()+" "+
                x.getQuantity()+" "+x.getOwnerID();
        System.out.println(answer);
    }

}
