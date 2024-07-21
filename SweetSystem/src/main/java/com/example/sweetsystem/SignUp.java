package com.example.sweetsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class SignUp {
@FXML
private AnchorPane signupPane;


public void switchToLoginPage() throws IOException {
    AnchorPane root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
    signupPane.getChildren().setAll(root);
}

}
