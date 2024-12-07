package com.example.demo.ui.menus;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WinGameMenu extends AbstractMenu {
    private static final String BACKGROUND_IMAGE_NAME = "winbg.jpg";
    private static final String WIN_IMAGE = "youWinLabel.png";
    private static final String REPLAY_IMAGE = "replayButtonImage.png";
    private static final String EXIT_IMAGE = "exitButtonImage.png";

    private final Runnable onReplay;

    public WinGameMenu(Stage stage, Runnable onReplay,double screenWidth, double screenHeight) {
        super(stage,BACKGROUND_IMAGE_NAME,screenWidth,screenHeight);
        this.onReplay=onReplay;
    }

    public void show(double screenWidth, double screenHeight) {

        Button replayButton=createImageButton(REPLAY_IMAGE,BUTTON_WIDTH,BUTTON_HEIGHT,onReplay);
        Button exitButton=createImageButton(EXIT_IMAGE,BUTTON_WIDTH,BUTTON_HEIGHT,stage::close);

        super.show(screenWidth,screenHeight,WIN_IMAGE,replayButton,exitButton);
    }

}