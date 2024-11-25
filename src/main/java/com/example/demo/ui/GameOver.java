package com.example.demo.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class GameOver {

    public GameOver() {
        Text gameOverText = new Text("Game Over");
        gameOverText.setFont(Font.font("Arial", 50));
        gameOverText.setFill(Color.RED);

        Button replayButton=new Button("Replay");
        replayButton.setFont(Font.font("Arial",50));
        replayButton.setOnAction(event-> {
        });
    }
}
/*
public class GameOver {

        // Game Over Text
        Text gameOverText = new Text("Game Over");
        gameOverText.setFont(Font.font("Arial", 50));
        gameOverText.setFill(Color.RED);

        // Replay Button
        Button replayButton = new Button("Replay");
        replayButton.setFont(Font.font("Arial", 20));
        replayButton.setOnAction(event -> {
            System.out.println("Replay button clicked");
            // Replace with the method that starts your game
        });

        // Quit Button
        Button quitButton = new Button("Quit");
        quitButton.setFont(Font.font("Arial", 20));
        quitButton.setOnAction(event -> {
            System.out.println("Quit button clicked");
            primaryStage.close(); // Close the application
        });

        // Layout
        VBox layout = new VBox(20);
        layout.getChildren().addAll(gameOverText, replayButton, quitButton);
        layout.setStyle("-fx-alignment: center; -fx-background-color: black;");

        // Scene
        Scene gameOverScene = new Scene(layout, 800, 600);

        // Show the Game Over Screen
        primaryStage.setScene(gameOverScene);
        primaryStage.show();

/*
    // Replace this with your actual game start method
    private void startGame(Stage primaryStage) {
        // Example to transition to a new game screen
        Text gameText = new Text("Game Screen");
        gameText.setFont(Font.font("Arial", 40));
        VBox gameLayout = new VBox(gameText);
        gameLayout.setStyle("-fx-alignment: center; -fx-background-color: lightblue;");
        Scene gameScene = new Scene(gameLayout, 800, 600);

        primaryStage.setScene(gameScene);
    }

}*/
