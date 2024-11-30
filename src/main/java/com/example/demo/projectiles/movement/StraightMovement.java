package com.example.demo.projectiles.movement;

import com.example.demo.projectiles.Projectile;

public class StraightMovement implements ProjectileMovementStrategy{

    private final int horizontalVelocity;

    public StraightMovement(int horizontalVelocity) {
        this.horizontalVelocity=horizontalVelocity;
    }

    @Override
    public void updatePosition(Projectile projectile) {
        projectile.moveHorizontally(horizontalVelocity);
    }
}
