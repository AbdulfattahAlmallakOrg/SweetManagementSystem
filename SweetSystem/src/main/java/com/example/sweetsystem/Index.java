package com.example.sweetsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Index implements Initializable {


    @FXML
    private AnchorPane ParentPane;
    @FXML
public static AnchorPane homePane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }
    public void toLogin() throws IOException {
        AnchorPane root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        ParentPane.getChildren().setAll(root);
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
