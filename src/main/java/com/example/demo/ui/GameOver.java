package com.example.demo.ui;

import com.example.demo.utils.ImageLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameOver {
    private static final String BACKGROUND_IMAGE_NAME = "gameOverBackground.jpeg";
    private static final String GAMEOVER_IMAGE = "gameOverLabelImage.png";
    private static final String REPLAY_IMAGE = "replayButtonImage.png";
    private static final String EXIT_IMAGE = "exitButtonImage.png";
    private static final int BUTTON_HEIGHT=75;
    private static final int BUTTON_WIDTH=250;
    private static final int TITLE_HEIGHT=150;
    private static final int TITLE_WIDTH=600;
    private static final int SCREEN_WIDTH = 1300;
    private static final int SCREEN_HEIGHT = 750;
    private final Stage stage;
    private final Runnable onReplay;
    private final ImageView background;

    public GameOver(Stage stage, Runnable onReplay) {
        this.stage=stage;
        this.onReplay=onReplay;
        this.background = new ImageView(ImageLoader.load(BACKGROUND_IMAGE_NAME));
    }

    public void show() {
        StackPane root = new StackPane();
        //ImageView background = new ImageView(ImageLoader.load(GAMEOVER_BG));
        background.setFitHeight(SCREEN_HEIGHT);
        background.setFitWidth(SCREEN_WIDTH);
        root.getChildren().add(background);

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        //layout.setStyle("-fx-padding: 30; -fx-alignment: center; -fx-background-image: ;");

        ImageView gameOverLabel = new ImageView(ImageLoader.load(GAMEOVER_IMAGE));
        gameOverLabel.setFitWidth(TITLE_WIDTH);
        gameOverLabel.setFitHeight(TITLE_HEIGHT);
        // Buttons
        Button replayButton=ImageButton(REPLAY_IMAGE,BUTTON_WIDTH,BUTTON_HEIGHT);
        Button exitButton=ImageButton(EXIT_IMAGE,BUTTON_WIDTH,BUTTON_HEIGHT);

        replayButton.setOnAction(event-> onReplay.run());
        exitButton.setOnAction(event->stage.close());

        layout.getChildren().addAll(gameOverLabel,replayButton,exitButton);

        root.getChildren().add(layout);
        Scene scene =new Scene(root,600,400);
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