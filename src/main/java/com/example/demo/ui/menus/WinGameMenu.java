package com.example.demo.ui.menus;

import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * The {@code WinGameMenu} class shows the screen when the player wins all levels.
 * It provides options to restart the game or exit.
 */
public class WinGameMenu extends AbstractMenu {
    private static final String BACKGROUND_IMAGE_NAME = "winbg.jpg";
    private static final String WIN_IMAGE = "youWinLabel.png";
    private static final String REPLAY_IMAGE = "replayButtonImage.png";
    private static final String EXIT_IMAGE = "exitButtonImage.png";

    private final Runnable onReplay;

    /**
     * constructs a {@code WinGameMenu} with a specified action for restarting the game
     *
     * @param stage         the stage to display the menu
     * @param onReplay   the action to execute when the replay button is clicked
     * @param screenWidth   the width of the menu screen
     * @param screenHeight  the height of the menu screen
     */

    public WinGameMenu(Stage stage, Runnable onReplay,double screenWidth, double screenHeight) {
        super(stage,BACKGROUND_IMAGE_NAME,screenWidth,screenHeight);
        this.onReplay=onReplay;
    }

    /**
     * displays the win game screen with buttons for restarting the game and exiting
     *
     * @param screenWidth   the width of the menu screen
     * @param screenHeight  the height of the menu screen
     */
    public void show(double screenWidth, double screenHeight) {

        Button replayButton=createImageButton(REPLAY_IMAGE, getButtonWidth(), getButtonHeight(),onReplay);
        Button exitButton=createImageButton(EXIT_IMAGE, getButtonWidth(), getButtonHeight(), getStage()::close);

        super.show(screenWidth,screenHeight,WIN_IMAGE,replayButton,exitButton);
    }

}