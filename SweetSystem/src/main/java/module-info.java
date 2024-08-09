module org.example.sweetmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sweetsystem to javafx.fxml;
    exports com.example.sweetsystem;
    exports com.example.sweetsystem.classes;
    opens com.example.sweetsystem.classes to javafx.fxml;
}