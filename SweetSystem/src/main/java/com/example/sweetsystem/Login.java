package com.example.sweetsystem;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;


public class Login {

@FXML
private  AnchorPane parentPane;



    public void switchToSignUp() throws IOException {
       AnchorPane root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignUp.fxml")));
        parentPane.getChildren().setAll(root);
        Index.header.setText("SignUp Page");
   }

}
