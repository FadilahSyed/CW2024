package com.example.demo.projectiles.movement;

import com.example.demo.projectiles.Projectile;

/**
 * implements a zigzag movement strategy for projectiles
 * projectile moves horizontally while oscillating verticall in
 * a sine wave pattern
 */
public class ZigZagMovement implements ProjectileMovementStrategy {
    private static final int HORIZONTAL_VELOCITY=-5;
    private static final int VERTICAL_AMPLITUDE=25;
    private static final int VERTICAL_CYCLE=10;
    private int frameCount=0;

    /**
     * updates the projectiles position to create zigzag motion
     * horizontal position changes at a constant velocity,
     * vertical position follows a sine wave pattern
     * @param projectile the projectile whose position needs to be updated
     */
    @Override
    public void updatePosition(Projectile projectile) {
        projectile.moveHorizontally(HORIZONTAL_VELOCITY);

        double verticalOffset = VERTICAL_AMPLITUDE * Math.sin(2 * Math.PI * frameCount / VERTICAL_CYCLE);
        projectile.moveVertically(verticalOffset);

        frameCount++;
    }
}
