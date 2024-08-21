module com.example.sweetsystem {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.example.sweetsystem.clasess;
    opens com.example.sweetsystem.clasess to javafx.fxml;
    exports com.example.sweetsystem.Controllers;
    opens com.example.sweetsystem.Controllers to javafx.fxml;
    exports com.example.sweetsystem;
    opens com.example.sweetsystem to javafx.fxml;

}