package com.example.sweetsystem.Controllers;

import com.example.sweetsystem.clasess.Product;
import com.example.sweetsystem.clasess.Recipe;
import com.example.sweetsystem.clasess.RecipesList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class Main implements Initializable {
@FXML
private AnchorPane ParentPane;
@FXML
private VBox recipesCont;

@FXML
private HBox topLeft;
@FXML
private HBox topRight;
@FXML
private ScrollPane postsScroll;

@FXML
private Pane filterPane;
@FXML
private TextField allergeField;
@FXML
private TextField searchField;
@FXML
private ScrollPane commentScroll;
@FXML
private VBox commentCont;
@FXML
private Label closeComment;
@FXML
private AnchorPane productPane;
@FXML
private ScrollPane productScroll;
@FXML
private HBox osamaBox;
@FXML
private HBox alertP;
    @FXML
    private HBox alertP1;
    @FXML
    private Button filterBtn;

    public void toggleBtns(HBox box1,HBox box2){
    box1.getStyleClass().remove("top-bar");
    box1.getStyleClass().add("top-bar-selected");
    box2.getStyleClass().remove("top-bar-selected");
    box2.getStyleClass().add("top-bar");
    }

    public void showProductBox(){
        filterBtn.setVisible(false);

    postsScroll.setVisible(false);
        productScroll.setVisible(true);
    toggleBtns(topRight,topLeft);

    }
    public void showPostsBox(){
        filterBtn.setVisible(true);
        postsScroll.setVisible(true);
        productScroll.setVisible(false);

        toggleBtns(topLeft,topRight);

    }

    public void goToManageAccount() throws IOException {
        AnchorPane root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ManageAccount.fxml")));
        ParentPane.getChildren().setAll(root);
        Index.header.setText("Profile page");

    }
    public void goToLoginPage() throws IOException {
        AnchorPane root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        ParentPane.getChildren().setAll(root);
        Index.header.setText("Login page");

    }
    public void addrecipecs() throws IOException {
        AnchorPane root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addUserPage.fxml")));
        ParentPane.getChildren().setAll(root);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setProducts();
        setResipes(RecipesList.Recipes);
    }

    private void setResipes(ArrayList<Recipe>recipes) {
        try {
            for(int i=0;i<recipes.size();i++){
                FXMLLoader fx=new FXMLLoader();
                fx.setLocation(getClass().getResource("RecipesCard.fxml"));
                HBox card=fx.load();
                RecipesCardController controller=fx.getController();
                controller.setData(recipes.get(i),commentCont,commentScroll,closeComment);
                recipesCont.getChildren().add(card);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void setProducts() {
        try {
            for (int i=0;i<Product.products.size();i++) {
                FXMLLoader fx = new FXMLLoader();
                fx.setLocation(getClass().getResource("ProductCard.fxml"));
                AnchorPane card = fx.load();
                ProductCardController controller = fx.getController();
                controller.setData(Product.products.get(i),alertP,alertP1);
                osamaBox.getChildren().add(card);
            }
         /*   for(int i=0;i<2;i++){
                FXMLLoader fx=new FXMLLoader();
                fx.setLocation(getClass().getResource("/com/example/sweetsystem/Controllers/ProductCard.fxml"));

                HBox card=fx.load();


                ProductCardController controller=fx.getController();


                controller.setData(Products.get(i));

                productPane.getChildren().add(card);
            }*/
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void openFilter(){
        filterPane.setVisible(true);
        allergeField.clear();
        searchField.clear();

    }

    public void closeFilter(){
        if(allergeField.getText().isEmpty()&&searchField.getText().isEmpty()){
            recipesCont.getChildren().clear();
            setResipes(RecipesList.Recipes);
        }
        filterPane.setVisible(false);
        allergeField.clear();
        searchField.clear();

    }

    public void searchButton(){

        ArrayList<Recipe> answer=new ArrayList<Recipe>();
        ArrayList<Recipe> recipe=RecipesList.Recipes;
        if(searchField.getText().isEmpty()&&!allergeField.getText().isEmpty()){
            answer=searchByAllergy(recipe);
        }
        else if(!searchField.getText().isEmpty()&&allergeField.getText().isEmpty()){
            answer=searchByName(recipe);
        }
        else{
            answer=searchByAllergy(recipe);
            answer=searchByName(answer);
        }
        clearRecipes();
        setResipes(answer);
        closeFilter();
    }

    private ArrayList<Recipe> searchByName(ArrayList<Recipe> recipe) {
        ArrayList<Recipe> answer=new ArrayList<Recipe>();
        for(int i=0;i<recipe.size();i++){
            if(recipe.get(i).getName().equals(searchField.getText())){
                answer.add(recipe.get(i));
            }
        }
        return answer;
    }

    private ArrayList<Recipe> searchByAllergy(ArrayList<Recipe> recipe) {
        ArrayList<Recipe> answer=new ArrayList<Recipe>();

        String allergy=allergeField.getText().toLowerCase();
        for(int i=0;i<recipe.size();i++){
            if(recipe.get(i).findAllerge(allergy)){
                answer.add(recipe.get(i));
            }
        }
        return answer;
    }

    private void clearRecipes() {
        recipesCont.getChildren().clear();
    }

    public void setCloseComment(){
        commentScroll.setVisible(false);
        closeComment.setVisible(false);
    }
    public void closeAlertP(){
        alertP.setVisible(false);
    }
    public void closeAlertP1(){
        alertP1.setVisible(false);
    }
}
