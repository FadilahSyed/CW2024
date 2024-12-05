package com.example.demo.ui.menus;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WinGameMenu extends AbstractMenu {
    private static final String BACKGROUND_IMAGE_NAME = "winGameBackground.jpeg";
    private static final String GAMEOVER_IMAGE = "youWin.png";
    private static final String REPLAY_IMAGE = "replayButtonImage.png";
    private static final String EXIT_IMAGE = "exitButtonImage.png";

    private final Runnable onReplay;

    public WinGameMenu(Stage stage, Runnable onReplay) {
        super(stage,BACKGROUND_IMAGE_NAME);
        this.onReplay=onReplay;
    }

    public void show() {

        Button replayButton=createImageButton(REPLAY_IMAGE,BUTTON_WIDTH,BUTTON_HEIGHT,onReplay);
        Button exitButton=createImageButton(EXIT_IMAGE,BUTTON_WIDTH,BUTTON_HEIGHT,stage::close);

        super.show(GAMEOVER_IMAGE,replayButton,exitButton);
    }

}