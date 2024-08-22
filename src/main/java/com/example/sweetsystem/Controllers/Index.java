package com.example.sweetsystem.Controllers;

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
