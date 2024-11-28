package com.example.demo.ui;

import com.example.demo.utils.ImageLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameOver {
    private static final String GAMEOVER_BG = "gameover.jpeg";
    private static final String START_IMAGE = "startbutton.png";
    private static final String EXIT_IMAGE = "exitbutton.png";
    private final Stage stage;
    private final Runnable onReplay;
    //private final ImageView background;

    public GameOver(Stage stage, Runnable onReplay) {
        this.stage=stage;
        this.onReplay=onReplay;
    }

    public void show() {
        //ImageView background = new ImageView(ImageLoader.load(GAMEOVER_BG));
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        //layout.setStyle("-fx-padding: 30; -fx-alignment: center; -fx-background-image: ;");

        // Buttons
        Button replayButton=ImageButton(START_IMAGE,200,50);
        Button exitButton=ImageButton(EXIT_IMAGE,200,50);

        replayButton.setOnAction(event-> onReplay.run());
        exitButton.setOnAction(event->stage.close());

        layout.getChildren().addAll(replayButton,exitButton);

        Scene scene =new Scene(layout,600,400);
        stage.setScene(scene);
        stage.show();
    }
    private Button ImageButton(String imagePath, int width, int height) {
        ImageView imageView= new ImageView(ImageLoader.load(imagePath));
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);

        Button button =new Button();
        button.setGraphic(imageView);
        button.setStyle("-fx-background-color: transparent; -fx-cursor:hand;");

        return button;
    }
}