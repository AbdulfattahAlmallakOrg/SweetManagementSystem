package com.example.sweetsystem.Controllers;

import com.example.sweetsystem.clasess.Client;
import com.example.sweetsystem.clasess.ManageAccounrHelper;
import com.example.sweetsystem.clasess.Recipe;
import com.example.sweetsystem.clasess.UsersList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

public class ManageAccount implements Initializable {
    public boolean alert=false;
    @FXML
    private HBox hbox1;
@FXML
private Label nameHeader;
    @FXML
    private HBox hbox2;
    @FXML
    private VBox recipesCont;

    @FXML
    public AnchorPane parentPane;
    @FXML
    private TextField editEmail;

    @FXML
    private TextField editPassword;
    @FXML
    private Pane backgroundPane;
    @FXML
    private TextField editUserName;
    @FXML
    private Label wronginfo;
    @FXML
    private ScrollPane commentScroll;
    @FXML
    private VBox commentBox;
    @FXML
    private Label closeComment;

    private void showAlert(int x){
    if(x==1&&!alert){
        hbox1.setVisible(true);
        alert=true;
    }
    else if(!alert){
        hbox2.setVisible(true);
        alert=true;
    }
    }

    public void editBtn(){
        hbox1.setVisible(false);
        hbox2.setVisible(false);
        alert=false;
    if(ManageAccounrHelper.checkAllEmpty(editUserName.getText(),editPassword.getText(),editEmail.getText())){
        showAlert(1);
    }else{


        if(ManageAccounrHelper.ChangeAllCheck(editUserName.getText(),editPassword.getText(),editEmail.getText())) {
            if(!editUserName.getText().isEmpty()) {
                UsersList.currentUser.setUserName(editUserName.getText());
            }
            if(!editPassword.getText().isEmpty()) {
                UsersList.currentUser.setPassword(editPassword.getText());
            }
            if(!editEmail.getText().isEmpty()) {
                UsersList.currentUser.setEmail(editEmail.getText());
            }
            setName();
            showAlert(0);
            UsersList.printAll();
        }
        else{
            wronginfo.setText("You cant use the same data !");

            showAlert(1);
        }
        if(alert==false){
            alert=true;
            showAlert(1);
        }
        clearInputs();


    }

    }

    private void clearInputs() {
        editEmail.setText("");
        editPassword.setText("");
        editUserName.setText("");
    }

    private boolean changeUserName() {

        if(ManageAccounrHelper.changeUserName(editUserName.getText())){

            return true;
        }
        else {
            wronginfo.setText("You cant use this name !");
            showAlert(1);
            return false;
        }

    }



    private boolean changeEmail() {
        if(ManageAccounrHelper.changeEmail(editEmail.getText())){
            return true;
        }
        else {

            wronginfo.setText("You cant use the same email !");
            showAlert(1);
            return false;
        }

    }


    public void goToMain() throws IOException {
        AnchorPane root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main.fxml")));
        parentPane.getChildren().setAll(root);
        Index.header.setText("Main Page");
    }
    public void close1(){
        hbox1.setVisible(false);
        alert=false;
    }
    public void close2(){
        alert=false;
        hbox2.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setRespies();
        setName();
    }

    private void setRespies() {
        Client client=(Client)UsersList.currentUser;
        ArrayList<Recipe>r=client.getRecipes();
        try {
        for(int i=0;i<r.size();i++){
            FXMLLoader fx=new FXMLLoader();
            fx.setLocation(getClass().getResource("RecipesCard.fxml"));
            HBox card=fx.load();
            RecipesCardController controller=fx.getController();
            controller.setData(r.get(i),commentBox,commentScroll,closeComment);
            recipesCont.getChildren().add(card);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setName() {
        nameHeader.setText("Welcome "+UsersList.currentUser.getUserName());
    }

    public void setCloseComment(){
        commentScroll.setVisible(false);
        closeComment.setVisible(false);
    }
}
