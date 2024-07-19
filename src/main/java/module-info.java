module org.example.sweetmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.sweetmanagementsystem to javafx.fxml;
    exports org.example.sweetmanagementsystem;
}