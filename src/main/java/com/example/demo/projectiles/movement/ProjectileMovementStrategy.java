package com.example.demo.projectiles.movement;

import com.example.demo.projectiles.Projectile;

/**
 * represents a movement strategy for projectiles
 * implementations of this interface define how a
 * projectiles position is updated
 */
public interface ProjectileMovementStrategy {
    /**
     * updates the position of the given projectile based on movement strategy
     * @param projectile the projectile whose position needs to be updated
     */
    void updatePosition(Projectile projectile);
}
