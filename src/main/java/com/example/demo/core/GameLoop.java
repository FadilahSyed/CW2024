package com.example.demo.core;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * The {@code GameLoop} class manages the main game loop,
 * periodically running update logic at specified intervals
 */
public class GameLoop {
    private final Timeline timeline;
    private final Runnable updateAction;

    /**
     * Constructs a {@code GameLoop} with a specified delay and update action
     *
     * @param millisecondDelay the delay (milliseconds) between each update
     * @param updateAction      the action to perform on each update
     */

    public GameLoop(int millisecondDelay, Runnable updateAction) {
        this.timeline = new Timeline();
        this.updateAction = updateAction;
        KeyFrame gameLoopFrame = new KeyFrame(Duration.millis(millisecondDelay), e -> updateAction.run());
        this.timeline.setCycleCount(Timeline.INDEFINITE);
        this.timeline.getKeyFrames().add(gameLoopFrame);
    }

    /**
     * Starts the game loop
     */
    public void start() {
        timeline.play();
    }

    /**
     * stops the game loop
     */
    public void stop() {
        timeline.stop();
    }
}

