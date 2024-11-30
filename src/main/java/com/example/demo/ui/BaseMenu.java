package com.example.demo.ui;


import com.example.demo.utils.ImageLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class BaseMenu {
    protected static final int BUTTON_HEIGHT=75;
    protected static final int BUTTON_WIDTH=250;
    protected static final int TITLE_HEIGHT=150;
    protected static final int TITLE_WIDTH =600;
    protected static final int SCREEN_WIDTH=1300;
    protected static final int SCREEN_HEIGHT =750;

    protected final Stage stage;
    private final String backgroundImageName;

    public BaseMenu(Stage stage, String backgroundImageName) {
        this.stage = stage;
        this.backgroundImageName = backgroundImageName;
    }

    public void show(String titleImagePath, Button... buttons) {
        StackPane root = new StackPane();

        // Set up the background
        ImageView background = new ImageView(ImageLoader.load(backgroundImageName));
        background.setFitHeight(stage.getHeight());
        background.setFitWidth(stage.getWidth());
        root.getChildren().add(background);

        // Set up the layout
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        background.fitWidthProperty().bind(root.widthProperty());
        background.fitHeightProperty().bind(root.heightProperty());

        // Add the title
        if (titleImagePath != null) {
            ImageView title = new ImageView(ImageLoader.load(titleImagePath));
            title.setFitWidth(TITLE_WIDTH);
            title.setFitHeight(TITLE_HEIGHT);
            layout.getChildren().add(title);
        }

        layout.getChildren().addAll(buttons);


        root.getChildren().add(layout);

        //layout.layoutXProperty().bind(root.widthProperty().subtract(layout.widthProperty()).divide(2));
        //layout.layoutYProperty().bind(root.heightProperty().subtract(layout.heightProperty()).divide(2));



        Scene currentScene=stage.getScene();
        if(currentScene!=null) {
            currentScene.setRoot(root);
            System.out.println("CurrentScene");
        } else {
            Scene newScene=new Scene(root,SCREEN_WIDTH,SCREEN_HEIGHT);
            stage.setScene(newScene);
        }

        // Set the scene

        //Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
        //stage.setScene(scene);
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

