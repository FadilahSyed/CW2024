package com.example.demo.actors.shield;

import com.example.demo.utils.CommonConstants;
import com.example.demo.ui.LevelViewLevelTwo;

/**
 * manages the activation, deactivation, and position of a shield for boss
 */
public class ShieldManager implements ShieldStrategy{
    private static final double SHIELD_PROBABILITY = CommonConstants.SHIELD_PROBABILITY;
    private static final int MAX_FRAMES_WITH_SHIELD = CommonConstants.MAX_FRAMES_WITH_SHIELD;
    private final LevelViewLevelTwo levelView;
    private boolean isShielded;
    private int activeShieldFrames;

    /**
     * constructs a {@code ShieldManager} associated with a level view.
     *
     * @param levelView the level view responsible for rendering the shield.
     */
    public ShieldManager(LevelViewLevelTwo levelView) {
        this.levelView=levelView;
        this.activeShieldFrames=0;
        this.isShielded=false;
    }

    /**
     * updates the shield state, including activation and deactivation logic
     */
    public void updateShield() {
        if (isShielded) activeShieldFrames++;
        else if (shouldActivateShield()) {
            activateShield();
        }
        if (shieldExhausted()) deactivateShield();
    }

    /**
     * determines whether the shield is active.
     *
     * @return {@code true} if the shield is active, otherwise {@code false}.
     */
    public boolean isShielded() {
        return isShielded;
    }

    /**
     * determines if shield should be activated with probability
     * @return {@code true} if shield should be activated, otherwise {@code false}
     */
    private boolean shouldActivateShield() {
        return Math.random() < SHIELD_PROBABILITY;
    }

    /**
     * checks maximum frames with shield has been reached
     * @return {@code true} if shield reached max frames, otherwise {@code false}
     */
    private boolean shieldExhausted() {
        return activeShieldFrames == MAX_FRAMES_WITH_SHIELD;
    }

    /**
     * shield appears + boss takes no damage
     */
    private void activateShield() {
        isShielded = true;
        activeShieldFrames=0;
        levelView.showShield();
    }
    /**
     * shield disappeares + boss takes damage
     */
    private void deactivateShield() {
        isShielded = false;
        activeShieldFrames = 0;
        levelView.hideShield();
    }

    /**
     * updates the shield's position relative to the plane.
     *
     * @param x the x-coordinate of the plane.
     * @param y the Y-coordinate of the plane.
     */
    public void updateShieldPosition(double x, double y) {
        levelView.updateShieldPosition(x, y);
    }

}
