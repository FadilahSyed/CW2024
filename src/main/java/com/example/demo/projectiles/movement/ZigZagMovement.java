package com.example.demo.projectiles.movement;

import com.example.demo.projectiles.Projectile;

public class ZigZagMovement implements ProjectileMovementStrategy {
    private static final int HORIZONTAL_VELOCITY=-5;
    private static final int VERTICAL_AMPLITUDE=25;
    private static final int VERTICAL_CYCLE=10;
    private int frameCount=0;

    @Override
    public void updatePosition(Projectile projectile) {
        projectile.moveHorizontally(HORIZONTAL_VELOCITY);

        double verticalOffset = VERTICAL_AMPLITUDE * Math.sin(2 * Math.PI * frameCount / VERTICAL_CYCLE);
        projectile.moveVertically(verticalOffset);

        frameCount++;
    }
}
