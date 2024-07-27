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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AddUserPage implements Initializable {

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
private String ImagePath;
FileChooser chooser=new FileChooser();


    public void backToMain() throws IOException {
        AnchorPane root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main.fxml")));
        ParentPane.getChildren().setAll(root);
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

            return ;
        }
        Recipe r=new Recipe(RName.getText(),ImagePath,RDescription.getText(),Rneed.getText(),RAllerg.getText());
        Client c=(Client) UsersList.currentUser;
        c.addRecipe(r);
        RecipesList.Recipes.add(r);
    }

    private boolean chekAllDataFill() {
        return !Rneed.getText().isEmpty() && !ImagePath.isEmpty()  && !RDescription.getText().isEmpty() && !RName.getText().isEmpty();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
