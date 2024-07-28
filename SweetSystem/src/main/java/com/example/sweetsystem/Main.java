package com.example.sweetsystem;

import com.example.sweetsystem.clasess.Client;
import com.example.sweetsystem.clasess.Recipe;
import com.example.sweetsystem.clasess.RecipesList;
import com.example.sweetsystem.clasess.UsersList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
private  VBox commentPane;




    public void toggleBtns(HBox box1,HBox box2){
    box1.getStyleClass().remove("top-bar");
    box1.getStyleClass().add("top-bar-selected");
    box2.getStyleClass().remove("top-bar-selected");
    box2.getStyleClass().add("top-bar");
    }

    public void showProductBox(){
    postsScroll.setVisible(false);
    toggleBtns(topRight,topLeft);

    }
    public void showPostsBox(){
        postsScroll.setVisible(true);
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
        setResipes(RecipesList.Recipes);
    }

    private void setResipes(ArrayList<Recipe>recipes) {


        try {
            for(int i=0;i<recipes.size();i++){
                FXMLLoader fx=new FXMLLoader();
                fx.setLocation(getClass().getResource("RecipesCard.fxml"));

                HBox card=fx.load();


                RecipesCardController controller=fx.getController();


                controller.setData(recipes.get(i));

                recipesCont.getChildren().add(card);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
