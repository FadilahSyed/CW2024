package com.example.demo.ui;

import com.example.demo.utils.ImageLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameOver {
    private final Stage stage;
    private final Runnable onReplay;
    //private final ImageView background;
    private static final String GAMEOVER_BG = "background2.jpeg";

    public GameOver(Stage stage, Runnable onReplay) {
        this.stage=stage;
        this.onReplay=onReplay;
    }

    public void show() {
        //ImageView background = new ImageView(ImageLoader.load(GAMEOVER_BG));
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