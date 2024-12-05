package com.example.demo.ui.menus;

import javafx.stage.Stage;
import javafx.scene.control.Button;


public class MainMenu extends AbstractMenu {
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
        TutorialPopUp tutorial =new TutorialPopUp();
        tutorial.show(stage);
    }
}
