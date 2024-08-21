package com.example.sweetsystem.Controllers;

import com.example.sweetsystem.clasess.RecipesList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

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
        AnchorPane root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main.fxml")));
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
        if(!RecipesList.chekAllDataFill(Rneed.getText(),ImagePath,RDescription.getText(),RName.getText())){
            alertF();
            return ;
        }
        RecipesList.makeRecipe(RName.getText(),ImagePath,RDescription.getText(),Rneed.getText(),RAllerg.getText());

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
}
