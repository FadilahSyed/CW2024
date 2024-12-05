module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo.controller to javafx.fxml;
    opens com.example.demo.ui to javafx.fxml;
    //opens com.example.demo.core to javafx.fxml;
    opens com.example.demo.actors to javafx.fxml;

    exports com.example.demo.controller;
    opens com.example.demo.projectiles to javafx.fxml;
    opens com.example.demo.actors.movement to javafx.fxml;
    opens com.example.demo.actors.shield to javafx.fxml;
    opens com.example.demo.actors.planes to javafx.fxml;
    //opens com.example.demo.core.Management to javafx.fxml;
    opens com.example.demo.core.levels to javafx.fxml;
    opens com.example.demo.utils to javafx.fxml;
    opens com.example.demo.core to javafx.fxml;
    opens com.example.demo.ui.components to javafx.fxml;
    opens com.example.demo.ui.menus to javafx.fxml;
}