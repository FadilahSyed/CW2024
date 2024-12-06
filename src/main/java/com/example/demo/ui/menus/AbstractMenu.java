package com.example.demo.ui.menus;


import com.example.demo.utils.ImageLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class AbstractMenu {
    protected static final int BUTTON_HEIGHT=75;
    protected static final int BUTTON_WIDTH=250;
    protected static final int TITLE_HEIGHT=150;
    protected static final int TITLE_WIDTH =600;
    protected static final int SCREEN_WIDTH=1300;
    protected static final int SCREEN_HEIGHT =750;

    protected final Stage stage;
    private final Group root;
    //private final Scene scene;
    private final ImageView background;
    private final String backgroundImageName;

    public AbstractMenu(Stage stage, String backgroundImageName, double screenWidth, double screenHeight) {
        this.root = new Group();
        this.backgroundImageName = backgroundImageName;
        //this.scene = new Scene(root, screenWidth, screenHeight);
        this.background = new ImageView(ImageLoader.load(backgroundImageName));

        this.stage = stage;
        //this.backgroundImageName = backgroundImageName;
    }

    public void show(double screenWidth, double screenHeight, String titleImagePath, Button... buttons) {
        //StackPane root = new StackPane();
        /*root.prefHeightProperty().unbind();
        root.prefWidthProperty().unbind();*/

        //root.prefWidthProperty().bind(stage.widthProperty());
        //root.prefHeightProperty().bind(stage.heightProperty());
       /* root.setPrefWidth(SCREEN_WIDTH);
        root.setPrefHeight(SCREEN_HEIGHT);
        root.setMinWidth(SCREEN_WIDTH);
        root.setMaxWidth(SCREEN_WIDTH);
        root.setMinHeight(SCREEN_HEIGHT);
        root.setMaxHeight(SCREEN_HEIGHT);*/


        //root.setPrefSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        //root.setAlignment(Pos.CENTER);

        // Set up the background
        //ImageView background = new ImageView(ImageLoader.load(backgroundImageName));
        //background.setFitHeight(stage.getHeight());
        //background.setFitWidth(stage.getWidth());
        //background.fitWidthProperty().bind(root.widthProperty());
        //background.fitHeightProperty().bind(root.heightProperty());

        Group root=new Group();
        background.setFitWidth(screenWidth);
        background.setFitHeight(screenHeight);

        root.getChildren().add(background);

        // Set up the layout
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        //layout.prefWidthProperty().bind(root.getWidth());
        //layout.prefHeightProperty().bind(root.heightProperty());
        layout.setStyle("-fx-border-color: red; -fx-border-width: 2; -fx-padding: 20; -fx-alignment: center;");
        layout.setPrefSize(screenWidth, screenHeight);

        // Add the title
        if (titleImagePath != null) {
            ImageView title = new ImageView(ImageLoader.load(titleImagePath));
            title.setFitWidth(TITLE_WIDTH);
            title.setFitHeight(TITLE_HEIGHT);
            layout.getChildren().add(title);
        }

        /*layout.getChildren().addAll(buttons);
        layout.setAlignment(Pos.CENTER);
        layout.setMaxSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        //layout.setStyle("-fx-padding: 20; -fx-alignment: center;"); // Center content
        layout.setPrefSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        layout.prefWidthProperty().bind(root.widthProperty());
        layout.prefHeightProperty().bind(root.heightProperty());
        layout.setStyle("-fx-border-color: red; -fx-border-width: 2;");
        root.setStyle("-fx-border-color: blue; -fx-border-width: 2;");
*/
        /*layout.setLayoutX((SCREEN_WIDTH - stage.getWidth()) / 2);
        layout.setLayoutY((SCREEN_HEIGHT - stage.getHeight()) / 2);
*/
        root.applyCss();
        root.layout();
        System.out.println("Stage Dimensions: " + stage.getWidth() + "x" + stage.getHeight());
        //System.out.println("Root Dimensions: " + root.getWidth() + "x" + root.getHeight());
        System.out.println("Layout Dimensions: " + layout.getWidth() + "x" + layout.getHeight());

        layout.getChildren().addAll(buttons);
        root.getChildren().add(layout);

        //layout.layoutXProperty().bind(root.widthProperty().subtract(layout.widthProperty()).divide(2));
        //layout.layoutYProperty().bind(root.heightProperty().subtract(layout.heightProperty()).divide(2));



        /*Scene currentScene=stage.getScene();
        if(currentScene!=null) {
            currentScene.setRoot(root);
            System.out.println("CurrentScene");
        } else {
            Scene newScene=new Scene(root,SCREEN_WIDTH,SCREEN_HEIGHT);
            stage.setScene(newScene);
        }*/


        // Set the scene

        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
        stage.setScene(scene);
        /*stage.setWidth(SCREEN_WIDTH);
        stage.setHeight(SCREEN_HEIGHT);
        stage.centerOnScreen();*/
        stage.show();
    }

    protected Button createImageButton(String imagePath, int width, int height, Runnable action) {
        ImageView imageView = new ImageView(ImageLoader.load(imagePath));
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);

        Button button = new Button();
        button.setGraphic(imageView);
        button.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");
        button.setOnAction(event -> action.run());

        return button;
    }
}

