package com.example.demo.projectiles;

import com.example.demo.projectiles.movement.ProjectileMovementStrategy;
import com.example.demo.projectiles.movement.ZigZagMovement;

public class MiniBossProjectile extends Projectile {
    private static final String IMAGE_NAME = "minibossprojectile.png";
    private static final int IMAGE_HEIGHT = 35;
    private final ProjectileMovementStrategy movementStrategy;

    public MiniBossProjectile(double initialXPos, double initialYPos) {
        super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos);
        this.movementStrategy = new ZigZagMovement();
    }

    @Override
    public void updatePosition() {
        movementStrategy.updatePosition(this);
    }

    @Override
    public void updateActor() {
        updatePosition();
    }
}
