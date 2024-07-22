package com.example.sweetsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.Objects;

public class SignUp {
    @FXML
private AnchorPane ParentPane;
    @FXML
private TextField passwordf;
    @FXML
private TextField usernamef;
    @FXML
private TextField emailf;
    @FXML
private HBox alert1;
    @FXML
private HBox alert2;
@FXML
private HBox alert3;



@FXML
    public void switchtoLogin() throws IOException {
    AnchorPane root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
    ParentPane.getChildren().setAll(root);
    Index.header.setText("Login Page");
    }
    private boolean checkAllInput(){
    return !emailf.getText().isEmpty()&&!usernamef.getText().isEmpty()&&!passwordf.getText().isEmpty();
    }
    private void makeUser(){
    if(UsersList.search(usernamef.getText())==-1) {
        User user = new User(usernamef.getText(), emailf.getText(), passwordf.getText());
        UsersList.users.add(user);
        alert2.setVisible(true);
        UsersList.printAll();
        clearInputs();
    }
    else{
        alert3.setVisible(true);
        UsersList.printAll();
    }
    }
public void signupBtn(){
    if(checkAllInput()){
        makeUser();
    }
    else{
alert1.setVisible(true);
    }
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

public void clearInputs(){
    emailf.setText("");
    passwordf.setText("");
    usernamef.setText("");
}


}
