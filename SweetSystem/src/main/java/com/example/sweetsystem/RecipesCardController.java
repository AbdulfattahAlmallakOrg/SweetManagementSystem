package com.example.sweetsystem;

import com.example.sweetsystem.clasess.Comment;
import com.example.sweetsystem.clasess.Recipe;
import com.example.sweetsystem.clasess.UsersList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
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
    private Recipe recipe;
    private VBox commentBox;
    private ScrollPane scroll;
    public void setData(Recipe r, VBox vBox, ScrollPane scrollPane) throws FileNotFoundException {
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
        scroll.setVisible(true);
        clearBox();
        HBox commentElementBox;
        Label userName;
        Label comment;
        ArrayList<Comment>c=recipe.getComments();
        for(int i=0;i<c.size();i++){
        userName=new Label(c.get(i).getWriterName());
        comment=new Label(c.get(i).getMessage());
            commentElementBox=new HBox();
            commentElementBox.getChildren().add(userName);
            commentElementBox.getChildren().add(comment);
            commentBox.getChildren().add(commentElementBox);
        }

    }

    private void clearBox() {
        commentBox.getChildren().clear();
    }




}



