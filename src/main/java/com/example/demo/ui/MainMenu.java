package com.example.demo.ui;

import com.example.demo.controller.Controller;
import com.example.demo.utils.ImageLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;


public class MainMenu extends BaseMenu{
    private static final String BACKGROUND_IMAGE_NAME = "gameoverbg.jpeg";
    private static final String TITLE_IMAGE = "titleLabelImage.png";
    private static final String START_IMAGE = "startButtonImage.png";
    private static final String TUTORIAL_IMAGE = "tutorialButtonImage.png";
    private static final String EXIT_IMAGE = "exitButtonImage.png";

    private final Runnable onStartGame;


    public MainMenu(Stage stage, Runnable onStartGame) {
        super(stage,BACKGROUND_IMAGE_NAME);
        this.onStartGame = onStartGame;
    }

    public void show() {
        Button startGameButton=createImageButton(START_IMAGE,BUTTON_WIDTH,BUTTON_HEIGHT,onStartGame);
        Button tutorialButton=createImageButton(TUTORIAL_IMAGE,BUTTON_WIDTH,BUTTON_HEIGHT,this::showTutorial);
        Button exitButton=createImageButton(EXIT_IMAGE,BUTTON_WIDTH,BUTTON_HEIGHT,stage::close);

        super.show(TITLE_IMAGE,startGameButton,tutorialButton,exitButton);
    }


    public void showTutorial() {
        Tutorial tutorial =new Tutorial();
        tutorial.show(stage);
    }
}
