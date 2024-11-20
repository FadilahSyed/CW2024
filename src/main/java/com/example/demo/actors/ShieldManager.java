package com.example.demo.actors;

import com.example.demo.ui.LevelViewLevelTwo;

public class ShieldManager {
    private static final double SHIELD_PROBABILITY = .002;
    private static final int MAX_FRAMES_WITH_SHIELD = 500;
    private final LevelViewLevelTwo levelView;
    private boolean isShielded;
    private int framesWithShieldActivated;

    public ShieldManager(LevelViewLevelTwo levelView) {
        this.levelView=levelView;
        this.framesWithShieldActivated=0;
        this.isShielded=false;
    }

    public void updateShield() {
        if (isShielded) framesWithShieldActivated++;
        else if (shouldActivateShield()) {
            activateShield();
        }
        if (shieldExhausted()) deactivateShield();
    }

    public boolean isShielded() {
        return isShielded;
    }
    private boolean shouldActivateShield() {
        return Math.random() < SHIELD_PROBABILITY;
    }

    private boolean shieldExhausted() {
        return framesWithShieldActivated == MAX_FRAMES_WITH_SHIELD;
    }

    private void activateShield() {
        isShielded = true;
        framesWithShieldActivated=0;
        levelView.showShield(); //calls method from levelviewlevel2
    }

    private void deactivateShield() {
        isShielded = false;
        framesWithShieldActivated = 0;
        levelView.hideShield(); //calls method from levelviewlevel2
    }
}
