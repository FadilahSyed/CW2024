/*package com.example.demo.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button startButton=new Button("Start");
        Button quitButton= new Button("Quit");

        startButton.setOnAction(event-> startGame(primaryStage));
        quitButton.setOnAction(event->System.exit(0));

        VBox layout = new VBox(20);
        layout.setStyle("-fx-alignment: center; -fx-padding: 20; -fx-spacing: 20; -fx-background-color: #2c3e50;");
        startButton.setStyle("-fx-font-size: 16px; -fx-background-color: #1abc9c; -fx-text-fill: white;");
        quitButton.setStyle("-fx-font-size: 16px; -fx-background-color: #e74c3c; -fx-text-fill: white;");

        layout.getChildren().addAll(startButton,quitButton);

        Scene scene = new Scene(layout,400,300);
        primaryStage.set;
    }
}
*/