package com.example.demo.ui.menus;

import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * The {@code GameOverMenu} class shows the screen when the player fails.
 * It provides options to restart the game or exit.
 */
public class GameOverMenu extends AbstractMenu {
    private static final String BACKGROUND_IMAGE_NAME = "gameoverbg.jpg";
    private static final String GAMEOVER_IMAGE = "gameOverLabel.png";
    private static final String REPLAY_IMAGE = "replayButtonImage.png";
    private static final String EXIT_IMAGE = "exitButtonImage.png";

    private final Runnable onReplay;

    /**
     * constructs a {@code GameOverMenu} with a specified action for restarting the game
     *
     * @param stage         the stage to display the menu
     * @param onReplay      the action to execute when the replay button is clicked
     * @param screenHeight  height of screen
     * @param screenWidth   width of screen
     */
    public GameOverMenu(Stage stage, Runnable onReplay, double screenWidth, double screenHeight) {
        super(stage,BACKGROUND_IMAGE_NAME, screenWidth, screenHeight);
        this.onReplay=onReplay;
    }

    /**
     * displays the gameover screen with buttons for restarting the game and exiting
     *
     * @param screenWidth   the width of the menu screen
     * @param screenHeight  the height of the menu screen
     */
    public void show(double screenWidth, double screenHeight) {

        Button replayButton=createImageButton(REPLAY_IMAGE, getButtonWidth(), getButtonHeight(),onReplay);
        Button exitButton=createImageButton(EXIT_IMAGE, getButtonWidth(), getButtonHeight(), getStage()::close);

        super.show(screenWidth, screenHeight,GAMEOVER_IMAGE,replayButton,exitButton);
    }

}