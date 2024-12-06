package com.example.demo.actors.shield;

import com.example.demo.actors.PlaneConstants;
import com.example.demo.ui.LevelViewLevelTwo;

public class ShieldManager implements ShieldStrategy{
    private static final double SHIELD_PROBABILITY = PlaneConstants.SHIELD_PROBABILITY;
    private static final int MAX_FRAMES_WITH_SHIELD = PlaneConstants.MAX_FRAMES_WITH_SHIELD;
    private final LevelViewLevelTwo levelView;
    private boolean isShielded;
    private int activeShieldFrames;

    public ShieldManager(LevelViewLevelTwo levelView) {
        this.levelView=levelView;
        this.activeShieldFrames=0;
        this.isShielded=false;
    }

    public void updateShield() {
        if (isShielded) activeShieldFrames++;
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
        return activeShieldFrames == MAX_FRAMES_WITH_SHIELD;
    }

    private void activateShield() {
        isShielded = true;
        activeShieldFrames=0;
        levelView.showShield();
    }

    private void deactivateShield() {
        isShielded = false;
        activeShieldFrames = 0;
        levelView.hideShield();
    }

    public void updateShieldPosition(double x, double y) {
        levelView.updateShieldPosition(x, y);
    }

}
