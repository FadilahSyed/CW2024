package com.example.demo.projectiles.movement;

import com.example.demo.projectiles.Projectile;

/**
 * implements a straightline movement strategy for projectiles
 * the projectile moves horizontally at a constant velocity
 */
public class StraightMovement implements ProjectileMovementStrategy{
    private final int horizontalVelocity;

    /**
     * constructs a {@code StraightMovement} strategy with the specified velocity
     * @param horizontalVelocity the constant horizontal velocity for the projecitle
     */
    public StraightMovement(int horizontalVelocity) {
        this.horizontalVelocity=horizontalVelocity;
    }

    /**
     * updates the projectiles position by moving ti horizontally at the configured velocity
     * @param projectile the projectile whose position needs to be updated
     */
    @Override
    public void updatePosition(Projectile projectile) {
        projectile.moveHorizontally(horizontalVelocity);
    }
}
