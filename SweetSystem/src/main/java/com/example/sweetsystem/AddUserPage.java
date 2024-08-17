package com.example.sweetsystem;

import com.example.sweetsystem.clasess.Client;
import com.example.sweetsystem.clasess.Recipe;
import com.example.sweetsystem.clasess.RecipesList;
import com.example.sweetsystem.clasess.UsersList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AddUserPage  {

    @FXML
    private AnchorPane ParentPane;

    @FXML
    private TextField RAllerg;

    @FXML
    private TextField RDescription;

    @FXML
    private TextField RName;

    @FXML
    private TextField Rneed;

    @FXML
    private ImageView image;
    @FXML
    private HBox closeAlert;
    @FXML
    private HBox checkAlert;
private String ImagePath;
FileChooser chooser=new FileChooser();


    public void backToMain() throws IOException {
        System.out.println("56");
        AnchorPane root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main.fxml")));
        System.out.println("555");

        ParentPane.getChildren().setAll(root);
        System.out.println("56");
    }

    public void gitImagePath(){
    File file=chooser.showOpenDialog(new Stage());
    System.out.println(file.getPath());
    ImagePath=file.getPath();
    Image img=new Image(file.getPath());

    image.setImage(img);
    }

    public void addButton() {
        if(!chekAllDataFill()){
            alertF();
            return ;
        }
        Recipe r=new Recipe(RName.getText(),ImagePath,RDescription.getText(),Rneed.getText(),RAllerg.getText());
        Client c=(Client) UsersList.currentUser;
        c.addRecipe(r);
        RecipesList.Recipes.add(r);
        clearInputs();
        alertS();
    }

    public void closeAlertS(){
        checkAlert.setVisible(false);


    }
    public void closeAlertF(){
        closeAlert.setVisible(false);


    }

    private void alertF() {
        closeAlert.setVisible(true);
    }

    private void alertS() {
        checkAlert.setVisible(true);

    }


    private void clearInputs() {
        ImagePath="";
        RName.clear();
        Rneed.clear();
        RAllerg.clear();
        RDescription.clear();

    }

    private boolean chekAllDataFill() {
        return !Rneed.getText().isEmpty() && !ImagePath.isEmpty()  && !RDescription.getText().isEmpty() && !RName.getText().isEmpty();
    }


}
