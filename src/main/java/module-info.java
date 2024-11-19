module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo.controller to javafx.fxml;
    opens com.example.demo.ui to javafx.fxml;
    opens com.example.demo.core to javafx.fxml;
    opens com.example.demo.actors to javafx.fxml;

    exports com.example.demo.controller;
}