package com.example.demo.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Tutorial {

    public void show(Stage ownerStage) {
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL); // Blocks interaction with the main window
        popupStage.initOwner(ownerStage);
        popupStage.setTitle("How to Play");

        // Instructions content
        Label instructionsLabel = new Label(
                "Welcome to Sky Battle!\n\n" +
                        "1. Use the arrow keys to move your character.\n" +
                        "2. Press the spacebar to shoot.\n" +
                        "3. Avoid enemy attacks and shoot them to earn points.\n" +
                        "4. Survive as long as you can to achieve a high score.\n\n" +
                        "Good luck!"
        );
        instructionsLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: black;");

        // Close button
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> popupStage.close());

        // Layout
        VBox layout = new VBox(10, instructionsLabel, closeButton);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        Scene scene = new Scene(layout, 400, 250);
        popupStage.setScene(scene);

        popupStage.showAndWait();
    }
}
