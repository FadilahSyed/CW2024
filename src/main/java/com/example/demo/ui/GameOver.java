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

public class GameOver extends BaseMenu{
    private static final String BACKGROUND_IMAGE_NAME = "gameOverBackground.jpeg";
    private static final String GAMEOVER_IMAGE = "gameOverLabelImage.png";
    private static final String REPLAY_IMAGE = "replayButtonImage.png";
    private static final String EXIT_IMAGE = "exitButtonImage.png";

    private final Runnable onReplay;

    public GameOver(Stage stage, Runnable onReplay) {
        super(stage,BACKGROUND_IMAGE_NAME);
        this.onReplay=onReplay;
    }

    public void show() {

        Button replayButton=createImageButton(REPLAY_IMAGE,BUTTON_WIDTH,BUTTON_HEIGHT,onReplay);
        Button exitButton=createImageButton(EXIT_IMAGE,BUTTON_WIDTH,BUTTON_HEIGHT,stage::close);

        super.show(GAMEOVER_IMAGE,replayButton,exitButton);
    }

}