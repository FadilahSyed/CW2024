package com.example.demo.core;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class GameLoop {
    private final Timeline timeline;
    private final Runnable updateAction;

    public GameLoop(int millisecondDelay, Runnable updateAction) {
        this.timeline = new Timeline();
        this.updateAction = updateAction;
        KeyFrame gameLoopFrame = new KeyFrame(Duration.millis(millisecondDelay), e -> updateAction.run());
        this.timeline.setCycleCount(Timeline.INDEFINITE);
        this.timeline.getKeyFrames().add(gameLoopFrame);
    }

    public void start() {
        timeline.play();
    }

    public void stop() {
        timeline.stop();
    }
}

