package com.example.sweetsystem;

import com.example.sweetsystem.clasess.Client;
import com.example.sweetsystem.clasess.Recipe;
import com.example.sweetsystem.clasess.UsersList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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
    private TextField editUserName;
    @FXML
    private Label wronginfo;

    private boolean checkAllEmpty(){
    return editUserName.getText().isEmpty()&&editPassword.getText().isEmpty()&&editEmail.getText().isEmpty();
    }
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
    if(checkAllEmpty()){
        showAlert(1);
    }else{


        if(changeUserName()&&changeEmail()&& changePassword()) {
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

        if(!editUserName.getText().equals(UsersList.currentUser.getUserName())&&UsersList.search(editUserName.getText())==-1){
            System.out.println("line 90");
            return true;
        }
        else {
            wronginfo.setText("You cant use this name !");
            showAlert(1);
            return false;
        }

    }

    private boolean changePassword() {

        if(!editPassword.getText().equals(UsersList.currentUser.getPassword())){
            System.out.println("line 106");

            return true;
        }
        else {

            wronginfo.setText("You cant use the same password !");

            showAlert(1);
            return false;
        }
    }

    private boolean changeEmail() {
        if(!editEmail.getText().equals(UsersList.currentUser.getEmail())){
            System.out.println("line 122");

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
        Recipe r = new Recipe("fff","C:/Users/osama/Desktop/draw_svg20210602-26376-1v1hun8.svg.png");
        Client c=(Client)UsersList.currentUser;
        c.addRecipe(r);
        r= new Recipe("fff","C:/Users/osama/Desktop/draw_svg20210602-26376-1v1hun8.svg.png");
        c.addRecipe(r);
        c.addRecipe(r);
        c.addRecipe(r);
        c.addRecipe(r);
        setRespies();
        setName();
    }

    private void setRespies() {
        Client client=(Client)UsersList.currentUser;
        ArrayList<Recipe>r=client.getRecipes();
        try {
            System.out.println("d");
        for(int i=0;i<r.size();i++){
            FXMLLoader fx=new FXMLLoader();
            System.out.println("dd");
            fx.setLocation(getClass().getResource("RecipesCard.fxml"));
            System.out.println("ddd");

            HBox card=fx.load();
            RecipesCardController controller=fx.getController();

            controller.setData(r.get(i));
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
}
