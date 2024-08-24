package com.example.sweetsystem.Controllers;

import com.example.sweetsystem.clasess.UsersList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OwnerPageController implements Initializable {
@FXML
    public VBox UsersOrders;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoadRecipes();
    }

    private void LoadRecipes() {
        ArrayList<UserOrder> u=search(UserOrderHelper.orders);
        for (int i = 0; i< u.size(); i++) {

            try {
                FXMLLoader fx = new FXMLLoader();
                fx.setLocation(getClass().getResource("UserOrderItem.fxml"));
                HBox card = fx.load();
                OrderItemsController controller = fx.getController();
                controller.setData(u.get(i));
                UsersOrders.getChildren().add(card);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private ArrayList<UserOrder> search(ArrayList<UserOrder> size) {
        ArrayList <UserOrder> answer=new ArrayList<UserOrder>();
        for (int i=0;i<size.size();i++){
            if(size.get(i).getStoreId()== UsersList.currentUser.getId()){
                answer.add(size.get(i));
            }
        }
        return answer;
    }
}
