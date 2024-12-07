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
    protected static final int TITLE_WIDTH =850;
    protected static final int SCREEN_WIDTH=1300;
    protected static final int SCREEN_HEIGHT =750;

    protected final Stage stage;
    private final ImageView background;
    private final String backgroundImageName;

    public AbstractMenu(Stage stage, String backgroundImageName, double screenWidth, double screenHeight) {
        this.backgroundImageName = backgroundImageName;
        this.background = new ImageView(ImageLoader.load(backgroundImageName));
        this.stage = stage;
    }

    public void show(double screenWidth, double screenHeight, String titleImagePath, Button... buttons) {
        Group root=new Group();
        background.setFitWidth(screenWidth);
        background.setFitHeight(screenHeight);

        root.getChildren().add(background);

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-border-width: 2; -fx-padding: 20; -fx-alignment: center;");
        layout.setPrefSize(screenWidth, screenHeight);

        if (titleImagePath != null) {
            ImageView title = new ImageView(ImageLoader.load(titleImagePath));
            title.setFitWidth(TITLE_WIDTH);
            title.setFitHeight(TITLE_HEIGHT);
            layout.getChildren().add(title);
        }

        root.applyCss();
        root.layout();

        layout.getChildren().addAll(buttons);
        root.getChildren().add(layout);


        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
        stage.setScene(scene);
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

