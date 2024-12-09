package com.example.demo.projectiles;

import com.example.demo.projectiles.movement.ProjectileMovementStrategy;
import com.example.demo.projectiles.movement.ZigZagMovement;

/**
 * represents a projectile fired by the miniboss with zigzag movement behavior! :)
 */
public class MiniBossProjectile extends Projectile {
    private static final String IMAGE_NAME = "minibossprojectile.png";
    private static final int IMAGE_HEIGHT = 35;
    private final ProjectileMovementStrategy movementStrategy;

    /**
     * constructs a {@code MiniBossProjectile} at the specified position.
     *
     * @param initialXPos the initial X-coordinate of the projectile.
     * @param initialYPos the initial Y-coordinate of the projectile.
     */
    public MiniBossProjectile(double initialXPos, double initialYPos) {
        super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos);
        this.movementStrategy = new ZigZagMovement();
    }

    /**
     * Updates the projectile's position by moving it with zigzag behaviour
     * Uses movementStrategy and ZigZagMovement class
     */
    @Override
    public void updatePosition() {
        movementStrategy.updatePosition(this);
    }

    /**
     * updates projectile
     */
    @Override
    public void updateActor() {
        updatePosition();
    }
}
