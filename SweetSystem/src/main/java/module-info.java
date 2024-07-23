module com.example.sweetsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sweetsystem to javafx.fxml;
    exports com.example.sweetsystem;
    exports com.example.sweetsystem.clasess;
    opens com.example.sweetsystem.clasess to javafx.fxml;
}