package com.example.demo.projectiles;

import com.example.demo.actors.ActiveActorDestructible;
public class ProjectileFactory {
    public static Projectile createProjectile(String type, double x, double y) {
        switch(type.toLowerCase()) {
            case "boss":
                return new BossProjectile(y);
            case "enemy":
                return new EnemyProjectile(x, y);
            case "user":
                return new UserProjectile(x,y);
            default:
                throw new IllegalArgumentException("Unknown projectile type: " + type);
        }
    }

}
