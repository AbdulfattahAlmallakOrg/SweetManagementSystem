package com.example.sweetsystem;

import com.example.sweetsystem.clasess.Comment;
import com.example.sweetsystem.clasess.Recipe;
import com.example.sweetsystem.clasess.UsersList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RecipesCardController {

    @FXML
    private ImageView cakeImage;
    @FXML
    private Label tag1;
    @FXML
    private Label tag2;
    @FXML
    private Label tag3;
    @FXML
    private Label cakeName;
    @FXML
    private Label description;
    @FXML
    private Label commentText;
    @FXML
    private TextArea commentField;
    private Label closebtn;

    private Pane backgroundPane;

    private Recipe recipe;
    private VBox commentBox;
    private ScrollPane scroll;
    public void setData(Recipe r, VBox vBox, ScrollPane scrollPane, Label closeComment) throws FileNotFoundException {
        recipe=r;
        commentBox=vBox;
        scroll=scrollPane;
        System.out.println(commentBox);
        System.out.println(scroll);
        cakeName.setText(r.getName());
        description.setText(r.getDescription());
        fillImage(r);
        fillAllergy(r);
        fillComment(r);
        commentBox.setStyle("-fx-background-color: rgba(0,0,0,0.4);"+"-fx-border-radius:20px;"+"-fx-background-radius: 20px;");
       scroll.setStyle("-fx-background-color: rgba(0,0,0,0.4);");
       closebtn=closeComment;
    }

    private void fillImage(Recipe r) throws FileNotFoundException {
        FileInputStream input = new FileInputStream(r.getImage());
        Image img = new Image(input);
        cakeImage.setImage(img);
    }

    private void fillComment(Recipe r) {
        int comment=r.getComments().size();
        commentText.setText("View All "+comment+" Comments");
    }

    private void fillAllergy(Recipe r) {
        ArrayList<String>allergy=r.getAllergy();
        if(1==allergy.size()){
            tag1.setText(allergy.get(0));

            tag2.setVisible(false);
            tag3.setVisible(false);
        }
        else if (2==allergy.size()){
            tag1.setText(allergy.get(0));
            tag2.setText(allergy.get(1));

            tag3.setVisible(false);
        }
        else if(3==allergy.size()){
            tag1.setText(allergy.get(0));
            tag2.setText(allergy.get(1));
            tag3.setText(allergy.get(2));
        }
        else {
            tag1.setVisible(false);
            tag2.setVisible(false);
            tag3.setVisible(false);
        }
    }
    public void commentBtn(){
        if(!commentField.getText().isEmpty()){
            Comment c=new Comment(UsersList.currentUser.getUserName(),commentField.getText());
            recipe.addComment(c);
            commentField.clear();
        }
        else{

        }
        fillComment(recipe);
    }
    public void showComents(){
       // backgroundPane.setVisible(true);
        System.out.println(backgroundPane);
        closebtn.setVisible(true);
        scroll.setVisible(true);
        clearBox();
        HBox commentElementBox;
        Label userName;
        Label comment;

        ArrayList<Comment>c=recipe.getComments();
        for(int i=0;i<c.size();i++){
        userName=new Label(c.get(i).getWriterName());
        comment=new Label(c.get(i).getMessage());
            setStylesOfComment(userName,comment);
            commentElementBox=new HBox();
            commentElementBox.getChildren().add(userName);
            commentElementBox.getChildren().add(comment);
            commentBox.getChildren().add(commentElementBox);
        }

    }

    private void setStylesOfComment(Label userName, Label comment) {
        userName.setStyle("-fx-background-color: #80a3ff;\n" +
                "    -fx-border-radius: 10px 0px 0px 10px;\n" +
                "    -fx-background-radius: 10px 0px 0px 10px;\n" +
                "    -fx-font-size: 20px;"+"-fx-padding: 5px;"+"-fx-text-fill: snow;"+"-fx-pref-height: 50px;"+"-fx-font-weight:900 ;"+"-fx-pref-width: 100px");

        comment.setStyle(" -fx-background-radius: 0px 10px 10px 0px;\n" +
                "    -fx-border-radius: 10px 10px 10px 10px;"+"    -fx-font-size: 14px;"+"-fx-padding: 5px;"+"-fx-background-color: #222;"+"-fx-pref-width: 600px;"+"-fx-text-fill: snow;"+"-fx-pref-height: 50px;");
    }


    private void clearBox() {
        commentBox.getChildren().clear();
    }




}



