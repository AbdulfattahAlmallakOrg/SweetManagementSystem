package com.example.sweetsystem;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.Objects;


public class Login {

@FXML
private  AnchorPane parentPane;
@FXML
private TextField username;
@FXML
private PasswordField password;

@FXML
private HBox alert;
@FXML
private Label alertMessage;

private boolean checkInputs(){
    return !password.getText().isEmpty()&&!username.getText().isEmpty();
}
public void loginBtnClick(){
    if(checkInputs()) {
        int index = UsersList.search(username.getText());
        if (index != -1) {
            User user=UsersList.users.get(index);
            if(user.getPassword().equals(password.getText())){
                UsersList.currentUser=user;
                goToPrimaryPage();
            }
            else{
                alertMessage.setText("Password is not correct");
                alert.setVisible(true);
            }
        } else {
            alertMessage.setText("The account not registered");
            alert.setVisible(true);
        }

    }
    else {
        alertMessage.setText("Fill All Fields To Login");
        alert.setVisible(true);
    }

}

    private void goToPrimaryPage() {

    }

    public void closeAlert(){
    alert.setVisible(false);
}


    public void switchToSignUp() throws IOException {
       AnchorPane root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignUp.fxml")));
        parentPane.getChildren().setAll(root);
        Index.header.setText("SignUp Page");
   }

}
