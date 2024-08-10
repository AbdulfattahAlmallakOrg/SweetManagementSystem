package com.example.sweetsystem;

import com.example.sweetsystem.clasess.Client;
import com.example.sweetsystem.clasess.UsersList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private void makeUser(){
    if(UsersList.search(usernamef.getText())==-1) {
        Client user = new Client(usernamef.getText(), emailf.getText(), passwordf.getText(),"Client");
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
    if(checkAllInput()&&isValidEmail(emailf.getText())){
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
