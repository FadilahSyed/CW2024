package com.example.demo.ui.menus;


import com.example.demo.utils.ImageLoader;
import com.example.demo.utils.PlaneConstants;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * An abstract base class for all game menus.
 * It provides common methods for rendering menu UI components
 */

public abstract class AbstractMenu {
    private static final int BUTTON_HEIGHT= PlaneConstants.BUTTON_HEIGHT;
    private static final int BUTTON_WIDTH=PlaneConstants.BUTTON_WIDTH;
    private static final int TITLE_HEIGHT=PlaneConstants.TITLE_HEIGHT;
    private static final int TITLE_WIDTH =PlaneConstants.TITLE_WIDTH;
    private static final int SCREEN_WIDTH=PlaneConstants.SCREEN_WIDTH;
    private static final int SCREEN_HEIGHT =PlaneConstants.SCREEN_HEIGHT;

    private final Stage stage;
    private final ImageView background;
    private final String backgroundImageName;

    /**
     * Constructs an {@code AbstractMenu} with a specified background
     * @param stage                 The stage to display the menu
     * @param backgroundImageName   The file name of the background image
     * @param screenWidth           The width of the screen
     * @param screenHeight          The height of the screen
     */

    public AbstractMenu(Stage stage, String backgroundImageName, double screenWidth, double screenHeight) {
        this.backgroundImageName = backgroundImageName;
        this.background = new ImageView(ImageLoader.load(backgroundImageName));
        this.stage = stage;
    }


    public static int getButtonHeight() {
        return BUTTON_HEIGHT;
    }

    public static int getButtonWidth() {
        return BUTTON_WIDTH;
    }

    public static int getTitleHeight() {
        return TITLE_HEIGHT;
    }

    public static int getTitleWidth() {
        return TITLE_WIDTH;
    }

    public static int getScreenWidth() {
        return SCREEN_WIDTH;
    }

    public static int getScreenHeight() {
        return SCREEN_HEIGHT;
    }

    /**
     * Shows the menu with a background, title, buttons
     * @param screenWidth       The width of the menu screen
     * @param screenHeight      The height of the menu screen
     * @param titleImagePath    The file path of the title image
     * @param buttons           Buttons to display in the menu
     */
    public void show(double screenWidth, double screenHeight, String titleImagePath, Button... buttons) {
        Group root=new Group();
        getBackground().setFitWidth(screenWidth);
        getBackground().setFitHeight(screenHeight);

        root.getChildren().add(getBackground());

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-border-width: 2; -fx-padding: 20; -fx-alignment: center;");
        layout.setPrefSize(screenWidth, screenHeight);

        if (titleImagePath != null) {
            ImageView title = new ImageView(ImageLoader.load(titleImagePath));
            title.setFitWidth(getTitleWidth());
            title.setFitHeight(getTitleHeight());
            layout.getChildren().add(title);
        }

        root.applyCss();
        root.layout();

        layout.getChildren().addAll(buttons);
        root.getChildren().add(layout);


        Scene scene = new Scene(root, getScreenWidth(), getScreenHeight());
        getStage().setScene(scene);
        getStage().show();
    }

    /**
     * Creates an image button with a specified size and action
     *
     * @param imagePath the file path to the button image
     * @param width     the width of the button
     * @param height    the height of the button
     * @param action    the action to perform when clicked
     * @return          a configured {@code Button}
     */
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

    public Stage getStage() {
        return stage;
    }

    public ImageView getBackground() {
        return background;
    }

    public String getBackgroundImageName() {
        return backgroundImageName;
    }
}

