/**
 * module descriptor for {@code com.example.demo} module
 * this module defines dependencies, exports packages and opens them for
 * reflective access required by JavaFX
 *
 * It is part of a JavaFX game application
 */
module com.example.demo {
    /**
     * requires {@code javafx.controls} module for
     */
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo.controller to javafx.fxml;
    opens com.example.demo.ui to javafx.fxml;
    opens com.example.demo.actors to javafx.fxml;

    exports com.example.demo.controller;
    opens com.example.demo.projectiles to javafx.fxml;
    opens com.example.demo.actors.movement to javafx.fxml;
    opens com.example.demo.actors.shield to javafx.fxml;
    opens com.example.demo.actors.planes to javafx.fxml;
    opens com.example.demo.core.levels to javafx.fxml;
    opens com.example.demo.utils to javafx.fxml;
    opens com.example.demo.core to javafx.fxml;
    opens com.example.demo.ui.components to javafx.fxml;
    opens com.example.demo.ui.menus to javafx.fxml;
}