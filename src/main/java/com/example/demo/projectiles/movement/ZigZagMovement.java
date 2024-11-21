package com.example.demo.projectiles.movement;

import com.example.demo.projectiles.Projectile;

public class ZigZagMovement implements ProjectileMovementStrategy {
    private static final int HORIZONTAL_VELOCITY=-5;
    private static final int AMPLITUDE=40;
    private int direction =1;

    @Override
    public void updatePosition(Projectile projectile) {
        projectile.moveHorizontally(HORIZONTAL_VELOCITY);
        projectile.moveVertically(direction*AMPLITUDE);
        direction*=-1;
    }
}
