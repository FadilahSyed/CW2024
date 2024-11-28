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


public class MainMenu {
    private static final String BACKGROUND_IMAGE_NAME = "gameoverbg.jpeg";
    private static final String TITLE_IMAGE = "titleLabelImage.png";
    private static final String START_IMAGE = "startButtonImage.png";
    private static final String TUTORIAL_IMAGE = "tutorialButtonImage.png";
    private static final String EXIT_IMAGE = "exitButtonImage.png";
    private static final int BUTTON_HEIGHT=75;
    private static final int BUTTON_WIDTH=250;
    private static final int TITLE_HEIGHT=150;
    private static final int TITLE_WIDTH=600;
    private static final int SCREEN_WIDTH = 1300;
    private static final int SCREEN_HEIGHT = 750;

    private final Stage stage;  // Reference to the application's main stage
    private final Runnable onStartGame;

    private final ImageView background;

    public MainMenu(Stage stage, Runnable onStartGame) {
        this.stage = stage;
        this.onStartGame = onStartGame;
        this.background = new ImageView(ImageLoader.load(BACKGROUND_IMAGE_NAME));
    }

    public void show() {
        StackPane root = new StackPane();
        //background.requestFocus();
        //background.setFocusTraversable(true);
        background.setFitHeight(SCREEN_HEIGHT);
        background.setFitWidth(SCREEN_WIDTH);
        root.getChildren().add(background);
        /*Image backgroundImage=new Image("file:resources/com/example/demo/images/background1.jpeg");
        BackgroundImage bgImage=new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        root.setBackground(new Background(bgImage));*/
        //background.setFocusTraversable(true);
        //background.setFitHeight(screenHeight);
        //background.setFitWidth(screenWidth);
        // Create UI elements
        VBox layout = new VBox(20); // Vertical box with 10px spacing
        layout.setAlignment(Pos.CENTER);

        ImageView gameTitleLabel = new ImageView(ImageLoader.load(TITLE_IMAGE));
        gameTitleLabel.setFitWidth(TITLE_WIDTH);
        gameTitleLabel.setFitHeight(TITLE_HEIGHT);
        //Label gameTitleLabel = new Label("SKY BATTLE!");
        //gameTitleLabel.setStyle("-fx-font-size: 75px; -fx-text-fill: black;");

        Button startGameButton=ImageButton(START_IMAGE,BUTTON_WIDTH,BUTTON_HEIGHT);
        Button tutorialButton=ImageButton(TUTORIAL_IMAGE,BUTTON_WIDTH,BUTTON_HEIGHT);
        Button exitButton=ImageButton(EXIT_IMAGE,BUTTON_WIDTH,BUTTON_HEIGHT);


        // Create Buttons
        //Button startGameButton = new Button("Start Game");
        //Button tutorialButton=new Button("How to play!");
        ///Button settingsButton = new Button("Settings");
        //Button exitButton = new Button("Exit");

        // Add event handlers
        startGameButton.setOnAction(e -> onStartGame.run());
        tutorialButton.setOnAction(e-> showTutorial());
        //settingsButton.setOnAction(e -> showSettings());
        exitButton.setOnAction(e -> stage.close());

        // Add buttons to layout
        layout.getChildren().addAll(gameTitleLabel,startGameButton, tutorialButton, exitButton);

        root.getChildren().add(layout);
        // Set the scene and display the stage
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    private Button ImageButton(String imagePath,int width, int height) {
        ImageView imageView= new ImageView(ImageLoader.load(imagePath));
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);

        Button button =new Button();
        button.setGraphic(imageView);
        button.setStyle("-fx-background-color: transparent; -fx-cursor:hand;");

        return button;
    }

    public void showTutorial() {
        Tutorial tutorial =new Tutorial();
        tutorial.show(stage);
    }
}
