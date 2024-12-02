package com.example.demo.core.Management;

import com.example.demo.actors.planes.UserPlane;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class BackgroundHandler {
    private final ImageView background;
    private final UserPlane user;
    private final LevelParent level;

    public BackgroundHandler(ImageView background, UserPlane user, LevelParent level) {
        this.background=background;
        this.user=user;
        this.level=level;
    }

    public void initializeBackground(Group root,double screenWidth,double screenHeight) {
        background.setFocusTraversable(true);
        background.setFitWidth(screenWidth);
        background.setFitHeight(screenHeight);

        background.setOnKeyPressed(this::handleKeyPress);
        background.setOnKeyReleased(this::handleKeyRelease);

        root.getChildren().add(background);
    }

    private void handleKeyPress(KeyEvent e) {
        KeyCode kc=e.getCode();
        if(kc==KeyCode.UP) user.moveUp();
        if(kc==KeyCode.DOWN) user.moveDown();
        if(kc==KeyCode.LEFT) user.moveLeft();
        if(kc==KeyCode.RIGHT) user.moveRight();
        if(kc==KeyCode.SPACE) level.fireProjectile();
    }

    private void handleKeyRelease(KeyEvent e) {
        KeyCode kc = e.getCode();
        if(kc==KeyCode.UP|| kc==KeyCode.DOWN) user.stopVertical();
        if(kc==KeyCode.LEFT|| kc==KeyCode.RIGHT) user.stopHorizontal();
    }


}
