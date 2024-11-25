package com.example.demo.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameOver {
    private final Stage stage;
    private final Runnable onReplay;

    public GameOver(Stage stage, Runnable onReplay) {
        this.stage=stage;
        this.onReplay=onReplay;
    }

    public void show() {
        VBox layout = new VBox(15);
        layout.setStyle("-fx-padding: 30; -fx-alignment: center; -fx-background-color: #000000;");

        // Buttons
        Button replayButton = new Button("Replay");
        Button quitButton = new Button("Quit");

        // Styling (optional)
        replayButton.setStyle("-fx-font-size: 16px; -fx-background-color: #4CAF50; -fx-text-fill: white;");
        quitButton.setStyle("-fx-font-size: 16px; -fx-background-color: #F44336; -fx-text-fill: white;");

        replayButton.setOnAction(event-> onReplay.run());
        quitButton.setOnAction(event->stage.close());

        layout.getChildren().addAll(replayButton,quitButton);

        Scene scene =new Scene(layout,600,400);
        stage.setScene(scene);
        stage.show();
    }
}