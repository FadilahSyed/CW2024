package com.example.demo.projectiles;

import com.example.demo.projectiles.movement.ProjectileMovementStrategy;
import com.example.demo.projectiles.movement.ZigZagMovement;

public class Enemy2Projectile extends Projectile {
    private static final String IMAGE_NAME = "enemyFire.png";
    private static final int IMAGE_HEIGHT = 30; //reduced the hitbox of normal enemy's projectile
    //private static final int HORIZONTAL_VELOCITY = -12;
    private final ProjectileMovementStrategy movementStrategy;

    public Enemy2Projectile(double initialXPos, double initialYPos) {
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