package com.example.demo.ui.menus;

import com.example.demo.utils.ImageLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TutorialPopUp {

    private static final String GIF = "calico.gif";
    protected static final int GIF_DIMENSIONS=100;

    public void show(Stage ownerStage) {
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL); // Blocks interaction with the main window
        popupStage.initOwner(ownerStage);
        popupStage.setTitle("How to Play?");


        Label instructionsLabel = new Label("Welcome to Space Battle!\n\n"
                + "You are a plane far from home.\nCan you survive through the vast unknown?\n\n"
                +"Instructions:\n"
                + "\t1. Use the arrow keys to move your character.\n" +
                "\t2. Press the spacebar to shoot.\n" + "\t3. Shoot enemy planes and avoid their fire.\n" +
                "\t4. Survive as long as you can to win!!!.\n\n" + "Have funnnn!"
        );
        instructionsLabel.setFont(new Font("Arial",15));
        instructionsLabel.setStyle("-fx-text-fill: black;");

        ImageView imageView = new ImageView(ImageLoader.load(GIF));
        imageView.setFitWidth(GIF_DIMENSIONS);
        imageView.setFitHeight(GIF_DIMENSIONS);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> popupStage.close());

        VBox layout = new VBox(10, instructionsLabel, closeButton);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        layout.getChildren().addAll(imageView);

        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK,null,null)));


        Scene scene = new Scene(layout, 450, 400);
        popupStage.setScene(scene);

        popupStage.showAndWait();
    }
}
