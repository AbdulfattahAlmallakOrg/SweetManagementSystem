package com.example.sweetsystem.Controllers;

import com.example.sweetsystem.Controllers.HelloApplication;
import com.example.sweetsystem.clasess.Client;
import com.example.sweetsystem.clasess.User;
import com.example.sweetsystem.clasess.UsersList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Index implements Initializable {

//
    @FXML
    private AnchorPane ParentPane;
    @FXML
    public  AnchorPane homePane;
    @FXML
    public  Label PageName;
    public static Label header;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Client c=new Client("osama","osama1111222@gmail.com","1","Client","nablus");
        User c2=new User("Waleed","ex@gmail.com","1","Admin","nablus");
        UsersList.users.add(c);
        UsersList.users.add(c2);
        header=PageName;
        pageTitel("Main Page");

    }
    public  void pageTitel(String name){
        this.PageName.setText(name);
    }
    public void toLogin() throws IOException {
        AnchorPane root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        ParentPane.getChildren().setAll(root);
        pageTitel("Login Page");
    }

@FXML
private void Close_stage(){
        System.exit(0);
}
@FXML
private void minimize_stage(){
        HelloApplication.stage.setIconified(true);
}

}
