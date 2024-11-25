package com.example.demo.ui;

import com.example.demo.controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu {
    private final Stage stage;  // Reference to the application's main stage
    private final Runnable onStartGame;

    public MainMenu(Stage stage, Runnable onStartGame) {
        this.stage = stage;
        this.onStartGame = onStartGame;
    }

    public void show() {
        // Create UI elements
        VBox layout = new VBox(15); // Vertical box with 10px spacing
        layout.setStyle("-fx-padding: 30; -fx-alignment: center; -fx-background-color: #f0f0f0;");

        // Create Buttons
        Button startGameButton = new Button("Start Game");
        Button tutorialButton=new Button("How to play!");
        //Button settingsButton = new Button("Settings");
        Button exitButton = new Button("Exit");

        // Add event handlers
        startGameButton.setOnAction(e -> onStartGame.run());
        tutorialButton.setOnAction(e-> showTutorial());
        //settingsButton.setOnAction(e -> showSettings());
        exitButton.setOnAction(e -> stage.close());

        // Add buttons to layout
        layout.getChildren().addAll(startGameButton, tutorialButton, exitButton);

        // Set the scene and display the stage
        Scene scene = new Scene(layout, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    public void showTutorial() {
        Tutorial tutorial =new Tutorial();
        tutorial.show(stage);
    }
}
