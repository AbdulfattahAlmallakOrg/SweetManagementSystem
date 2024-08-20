package com.example.sweetsystem;
import com.example.sweetsystem.clasess.User;

import com.example.sweetsystem.clasess.UsersList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.HashMap;
import java.util.Map;

public class UserStatisticsController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ComboBox<String> cityComboBox;

    @FXML
    private TableView<UserStatistics> statisticsTable;

    @FXML
    private TableColumn<UserStatistics, String> cityColumn;

    @FXML
    private TableColumn<UserStatistics, Integer> userCountColumn;

    @FXML
    private Button showStatisticsButton;

    @FXML
    public void initialize() {
        // Initialize table columns
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        userCountColumn.setCellValueFactory(new PropertyValueFactory<>("userCount"));

        // Populate cityComboBox with city names from UsersList
        cityComboBox.setItems(FXCollections.observableArrayList(getCitiesFromUsers()));
    }

    @FXML
    public void showStatistics() {
        String selectedCity = cityComboBox.getValue();
        if (selectedCity != null) {
            statisticsTable.getItems().clear(); // Clear previous results
            statisticsTable.getItems().addAll(getUserStatisticsByCity(selectedCity));
        }
    }

    private ObservableList<UserStatistics> getUserStatisticsByCity(String city) {
        Map<String, Integer> cityUserCount = new HashMap<>();
        for (User user : UsersList.users) {
            if (user.getLocation().equalsIgnoreCase(city)) {
                cityUserCount.put(city, cityUserCount.getOrDefault(city, 0) + 1);
            }
        }

        ObservableList<UserStatistics> statistics = FXCollections.observableArrayList();
        statistics.add(new UserStatistics(city, cityUserCount.getOrDefault(city, 0)));
        return statistics;
    }

    private ObservableList<String> getCitiesFromUsers() {
        Map<String, Boolean> cityMap = new HashMap<>();
        for (User user : UsersList.users) {
            cityMap.put(user.getLocation(), true);
        }
        return FXCollections.observableArrayList(cityMap.keySet());
    }

    public static class UserStatistics {
        private final String city;
        private final int userCount;

        public UserStatistics(String city, int userCount) {
            this.city = city;
            this.userCount = userCount;
        }

        public String getCity() {
            return city;
        }

        public int getUserCount() {
            return userCount;
        }
    }
}
