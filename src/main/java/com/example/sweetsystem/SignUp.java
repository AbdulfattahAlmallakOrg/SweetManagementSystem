package com.example.sweetsystem;

import com.example.sweetsystem.clasess.Admin;
import com.example.sweetsystem.clasess.Client;
import com.example.sweetsystem.clasess.User;
import com.example.sweetsystem.clasess.UsersList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp implements Initializable {
    @FXML
    private ChoiceBox RoleBox;
    public String [] role={"Owner","Client","Supplier"};
    @FXML
private AnchorPane ParentPane;

    @FXML
    public TextField passwordf;
    @FXML
    public TextField usernamef;
    @FXML
    public TextField emailf;
    @FXML
private HBox alert1;
    @FXML
private HBox alert2;
@FXML
private HBox alert3;
@FXML
public TextField locationf;
    @FXML
    public TextField rolef;




@FXML
    public void switchtoLogin() throws IOException {
    AnchorPane root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
    ParentPane.getChildren().setAll(root);
    Index.header.setText("Login Page");
    }


    private void makeUser(){
    if(UsersList.makeUser(usernamef.getText(),emailf.getText(),passwordf.getText(),locationf.getText(),rolef.getText())) {
        alert2.setVisible(true);
        clearInputs();
    }
    else{
        alert3.setVisible(true);
    }
    }


public void signupBtn(){
    if(UsersList.checkAllInput(usernamef.getText(),passwordf.getText(),emailf.getText(),locationf.getText(),rolef.getText())&&UsersList.isValidEmail(emailf.getText())&&UsersList.isValidRole(rolef.getText())){
        makeUser();
    }
    else{
alert1.setVisible(true);
    }
}





public void clearInputs(){

    emailf.setText("");
    passwordf.setText("");
    usernamef.setText("");
    rolef.setText("");
    locationf.setText("");
}
    public void closeAlert(){
        alert1.setVisible(false);
    }
    public void closeAlert2(){
        alert2.setVisible(false);
    }
    public void closeAlert3(){
        alert3.setVisible(false);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    RoleBox.getItems().addAll(role);
    RoleBox.setOnAction(this::setRole);
    }

    private void setRole(Event event) {
        rolef.setText((String) RoleBox.getValue());

    }



}
