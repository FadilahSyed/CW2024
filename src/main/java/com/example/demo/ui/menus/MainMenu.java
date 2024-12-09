package com.example.demo.ui.menus;

import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * The {@code MainMenu} class shows the main menu screen of the game.
 * It provides options to start the game, view a tutorial or exit.
 */
public class MainMenu extends AbstractMenu {
    private static final String BACKGROUND_IMAGE_NAME = "background1.jpg";
    private static final String TITLE_IMAGE = "titleLabel.png";
    private static final String START_IMAGE = "startButtonImage.png";
    private static final String TUTORIAL_IMAGE = "tutorialButtonImage.png";
    private static final String EXIT_IMAGE = "exitButtonImage.png";

    private final Runnable onStartGame;

    /**
     * constructs a {@code MainMenu} with a specified action for starting the game
     *
     * @param stage         the stage to display the menu
     * @param onStartGame   the action to execute when the start button is clicked
     * @param screenWidth   the width of the menu screen
     * @param screenHeight  the height of the menu screen
     */
    public MainMenu(Stage stage, Runnable onStartGame,double screenWidth, double screenHeight) {
        super(stage,BACKGROUND_IMAGE_NAME,screenWidth,screenHeight);
        this.onStartGame = onStartGame;
    }

    /**
     * displays the main menu with buttons for starting the game,
     * viewing the tutorial, and exiting
     *
     * @param screenWidth   the width of the menu screen
     * @param screenHeight  the height of the menu screen
     */
    public void show(double screenWidth, double screenHeight) {
        Button startGameButton=createImageButton(START_IMAGE, getButtonWidth(), getButtonHeight(),onStartGame);
        Button tutorialButton=createImageButton(TUTORIAL_IMAGE, getButtonWidth(), getButtonHeight(),this::showTutorial);
        Button exitButton=createImageButton(EXIT_IMAGE, getButtonWidth(), getButtonHeight(), getStage()::close);

        super.show(screenWidth,screenHeight,TITLE_IMAGE,startGameButton,tutorialButton,exitButton);
    }

    /**
     * displays the tutorial pop up screen
     */
    public void showTutorial() {
        TutorialPopUp tutorial =new TutorialPopUp();
        tutorial.show(getStage());
    }
}
