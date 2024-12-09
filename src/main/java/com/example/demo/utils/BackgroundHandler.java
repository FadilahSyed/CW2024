package com.example.demo.utils;

import com.example.demo.actors.planes.UserPlane;
import com.example.demo.core.AbstractLevel;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * The {@code BackgroundHandler} class manages the background image + handles user input for
 *  controlling the player's userplane in the game
 */
public class BackgroundHandler {
    private final ImageView background;
    private final UserPlane user;
    private final AbstractLevel level;

    /**
     * constructs a {@code BackgroundHandler} with the specified background, user plane, and level
     *
     * @param background the background image for the game level
     * @param user       the user's plane
     * @param level      the current level instance to handle game actions like firing projectiles
     */
    public BackgroundHandler(ImageView background, UserPlane user, AbstractLevel level) {
        this.background=background;
        this.user=user;
        this.level=level;
    }

    /**
     * initializes the background + sets up key event listeners for user input
     *
     * @param root          the root group to which the background is added.
     * @param screenWidth   the width of the game screen.
     * @param screenHeight  the height of the game screen.
     */
    public void initializeBackground(Group root,double screenWidth,double screenHeight) {
        background.setFocusTraversable(true);
        background.setFitWidth(screenWidth);
        background.setFitHeight(screenHeight);

        background.setOnKeyPressed(this::handleKeyPress);
        background.setOnKeyReleased(this::handleKeyRelease);

        root.getChildren().add(background);
    }

    /**
     * handles key press events to move the player's plane or fire projectiles
     *
     * @param e the key event triggered when a key is pressed
     */
    private void handleKeyPress(KeyEvent e) {
        KeyCode kc=e.getCode();
        if(kc==KeyCode.UP) user.moveUp();
        if(kc==KeyCode.DOWN) user.moveDown();
        if(kc==KeyCode.LEFT) user.moveLeft();
        if(kc==KeyCode.RIGHT) user.moveRight();
        if(kc==KeyCode.SPACE) level.fireProjectile();
    }

    /**
     * handles key release events to stop the player's plane movement
     *
     * @param e the key event triggered when a key is released
     */
    private void handleKeyRelease(KeyEvent e) {
        KeyCode kc = e.getCode();
        if(kc==KeyCode.UP|| kc==KeyCode.DOWN) user.stopVertical();
        if(kc==KeyCode.LEFT|| kc==KeyCode.RIGHT) user.stopHorizontal();
    }

}
