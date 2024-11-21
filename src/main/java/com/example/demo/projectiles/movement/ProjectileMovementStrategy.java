package com.example.demo.projectiles.movement;

import com.example.demo.projectiles.Projectile;

public interface ProjectileMovementStrategy {
    void updatePosition(Projectile projectile);
}
