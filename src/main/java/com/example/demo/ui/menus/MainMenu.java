package com.example.demo.ui.menus;

import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class MainMenu extends AbstractMenu {
    private static final String BACKGROUND_IMAGE_NAME = "background1.jpg";
    private static final String TITLE_IMAGE = "titleLabel.png";
    private static final String START_IMAGE = "startButtonImage.png";
    private static final String TUTORIAL_IMAGE = "tutorialButtonImage.png";
    private static final String EXIT_IMAGE = "exitButtonImage.png";

    private final Runnable onStartGame;
    //private final Group root;


    public MainMenu(Stage stage, Runnable onStartGame,double screenWidth, double screenHeight) {
        super(stage,BACKGROUND_IMAGE_NAME,screenWidth,screenHeight);
        this.onStartGame = onStartGame;
    }

    public void show(double screenWidth, double screenHeight) {
        Button startGameButton=createImageButton(START_IMAGE,BUTTON_WIDTH,BUTTON_HEIGHT,onStartGame);
        Button tutorialButton=createImageButton(TUTORIAL_IMAGE,BUTTON_WIDTH,BUTTON_HEIGHT,this::showTutorial);
        Button exitButton=createImageButton(EXIT_IMAGE,BUTTON_WIDTH,BUTTON_HEIGHT,stage::close);

        super.show(screenWidth,screenHeight,TITLE_IMAGE,startGameButton,tutorialButton,exitButton);
    }


    public void showTutorial() {
        TutorialPopUp tutorial =new TutorialPopUp();
        tutorial.show(stage);
    }
}
